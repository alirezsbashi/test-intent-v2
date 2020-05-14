package arb.test.intent.v2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tel.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:09123456789")
            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
            else
                Toast.makeText(applicationContext, "No plan to run", Toast.LENGTH_SHORT).show()

        }

        email.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "*/*"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("alirezabashi98@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
            intent.putExtra(Intent.EXTRA_TEXT, "text")
            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
            else
                Toast.makeText(applicationContext, "No plan to run", Toast.LENGTH_SHORT).show()

        }

        web.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
            else
                Toast.makeText(applicationContext, "No plan to run", Toast.LENGTH_SHORT).show()

        }

        map.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:33,46")
            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
            else
                Toast.makeText(applicationContext, "No plan to run", Toast.LENGTH_SHORT).show()

        }

    }
}
