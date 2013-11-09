import models.Account;
import models.Training;
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
        if (Play.mode == Play.Mode.DEV && Account.count() == 0)
        {
            Fixtures.deleteAllModels();
            Fixtures.loadModels("test-datas.yml");
        }
        
        if (Play.mode == Play.Mode.PROD && Training.count() == 0 && Account.count() == 0)
        {
            Fixtures.loadModels("initial-load.yml");
        }
    }
}
