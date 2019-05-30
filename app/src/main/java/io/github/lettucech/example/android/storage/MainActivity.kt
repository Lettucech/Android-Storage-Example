package io.github.lettucech.example.android.storage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filesDir?.let {
            textView_internal_dir.text = it.absolutePath
        }

        getExternalFilesDir("")?.let {
            textView_external_dir.text = it.absolutePath
        } ?: run {
            textView_external_dir.text = R.string.dir_not_exists.toString()
        }

        btn_load_to_internal.setOnClickListener {
            ImageSelectorBottomSheetDialogFragment().show(supportFragmentManager, ImageSelectorBottomSheetDialogFragment.TAG)
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
