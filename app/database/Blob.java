package database;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.HibernateException;
import org.hibernate.type.WrapperBinaryType;
import org.hibernate.usertype.UserType;
import play.db.Model.BinaryField;
import play.exceptions.UnexpectedException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Custom type pour stocker les images en base
 * Le type "Blob" proposé par Play ne permet qu'un stockage sur disque,
 * inutile sur Heroku avec ces disques volatiles
 */
public class Blob implements BinaryField, UserType {

    private byte[]data;

    public Blob() {}

    private Blob(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public InputStream get() {
        if(exists()) {
            try {
                return new ByteArrayInputStream(data);
            } catch(Exception e) {
                throw new UnexpectedException(e);
            }
        }
        return null;
    }

    @Override
    public void set(InputStream is, String type) {
        try {
            data = IOUtils.toByteArray(is);
        } catch (IOException e) {
            throw new UnexpectedException(e);
        }
    }

    @Override
    public long length() {
        return data.length;
    }

    @Override
    public String type() {
        return "binary";
    }

    @Override
    public boolean exists() {
        return data != null && data.length != 0;
    }
    //

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.VARBINARY};
    }

    @Override
    public Class returnedClass() {
        return Blob.class;
    }

    private static boolean equal(Object a, Object b) {
      return a == b || (a != null && a.equals(b));
    }

    public boolean equals(Object o, Object o1) throws HibernateException {
        if(o instanceof Blob && o1 instanceof Blob) {
            return equal(((Blob)o).data, ((Blob)o1).data);
        }
        return equal(o, o1);
    }

    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object o) throws HibernateException, SQLException {
        Byte[] data = (Byte[]) WrapperBinaryType.INSTANCE.get(resultSet, names[0]);
        if(data == null || data.length == 0) {
            return new Blob();
        }
        return new Blob(ArrayUtils.toPrimitive(data));
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, Object o, int i) throws HibernateException, SQLException {
         if(o != null && ((Blob) o).exists()) {
            ps.setBytes(i, ((Blob) o).data);
        } else {
            ps.setNull(i, Types.BLOB);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        if(o == null) {
            return null;
        }
        return new Blob(((Blob)o).data);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object assemble(Serializable srlzbl, Object o) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //
}
