package app.viscount.loader.view.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import app.viscount.loader.R
import app.viscount.loader.databinding.ActivitySettingBinding
import app.viscount.loader.util.inflate
import app.viscount.loader.view.base.BaseActivity

class SettingActivity : BaseActivity() {

    private val viewBinding: ActivitySettingBinding by inflate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initToolbar(viewBinding.toolbarLayout.toolbar, R.string.setting, true)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, SettingFragment())
                .commit()
    }

    companion object{
        fun start(context: Context){
            val intent = Intent(context,SettingActivity::class.java)
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            context.startActivity(intent)
        }
    }

}