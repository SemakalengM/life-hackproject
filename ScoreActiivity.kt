class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val resultText = findViewById<TextView>(R.id.resultText)
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)

        scoreText.text = "Score: $score / $total"

        resultText.text = when {
            score >= total * 0.8 -> "Master Hacker! 💡"
            score >= total * 0.5 -> "Good job! 👍"
            else -> "Keep practising! 📚"
        }

        reviewBtn.setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }
    }
}