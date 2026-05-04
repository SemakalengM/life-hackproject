import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val container = findViewById<LinearLayout>(R.id.reviewContainer)

        for (q in QuestionsRepository.questions) {
            val textView = TextView(this)
            textView.text = "${q.statement}\nAnswer: ${q.isTrue}\n${q.explanation}\n"
            container.addView(textView)
        }
    }
}