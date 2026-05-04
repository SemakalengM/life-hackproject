class QuizActivity : AppCompatActivity() {

    private val questions = QuestionRepository.questions
    private var currentIndex = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val trueBtn = findViewById<Button>(R.id.trueBtn)
        val falseBtn = findViewById<Button>(R.id.falseBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        loadQuestion()

        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }

        nextBtn.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[currentIndex].statement
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correct = questions[currentIndex].isTrue

        if (userAnswer == correct) {
            score++
            feedbackText.text = "Correct! 🎉"
        } else {
            feedbackText.text = "Wrong! ❌"
        }
    }
}