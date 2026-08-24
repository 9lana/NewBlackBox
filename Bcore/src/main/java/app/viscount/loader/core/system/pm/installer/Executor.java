package app.viscount.loader.core.system.pm.installer;

import app.viscount.loader.core.system.pm.BPackageSettings;
import app.viscount.loader.entity.pm.InstallOption;


public interface Executor {
    public static final String TAG = "InstallExecutor";

    int exec(BPackageSettings ps, InstallOption option, int userId);
}
