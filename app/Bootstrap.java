import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import models.Training;
import models.User;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job
{
    /**
     * load test data in DEV mode only
     * not used in real world
     */
    public void doJob()
    {
        if (Play.mode == Play.Mode.DEV && User.count() == 0)
        {
            Fixtures.deleteAllModels();
            Fixtures.loadModels("test-datas.yml");
        }
        
        if (Play.mode == Play.Mode.PROD && Training.count() == 0 && User.count() == 0)
        {
            Fixtures.loadModels("initial-load.yml");
        }
    }
}
