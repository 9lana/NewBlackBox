package app.viscount.loader.core.system.pm.installer;

import app.viscount.loader.core.env.BEnvironment;
import app.viscount.loader.core.system.pm.BPackageSettings;
import app.viscount.loader.entity.pm.InstallOption;
import app.viscount.loader.utils.FileUtils;


public class RemoveUserExecutor implements Executor {

    @Override
    public int exec(BPackageSettings ps, InstallOption option, int userId) {
        String packageName = ps.pkg.packageName;
        
        FileUtils.deleteDir(BEnvironment.getDataDir(packageName, userId));
        FileUtils.deleteDir(BEnvironment.getDeDataDir(packageName, userId));
        FileUtils.deleteDir(BEnvironment.getExternalDataDir(packageName, userId));
        return 0;
    }
}
