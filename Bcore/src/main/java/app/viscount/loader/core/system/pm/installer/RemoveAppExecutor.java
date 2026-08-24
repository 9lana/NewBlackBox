package app.viscount.loader.core.system.pm.installer;

import app.viscount.loader.core.env.BEnvironment;
import app.viscount.loader.core.system.pm.BPackageSettings;
import app.viscount.loader.entity.pm.InstallOption;
import app.viscount.loader.utils.FileUtils;


public class RemoveAppExecutor implements Executor {
    @Override
    public int exec(BPackageSettings ps, InstallOption option, int userId) {
        FileUtils.deleteDir(BEnvironment.getAppDir(ps.pkg.packageName));
        return 0;
    }
}
