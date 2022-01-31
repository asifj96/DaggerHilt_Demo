package com.ninesol.wordapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.ninesol.wordapp.R
import com.ninesol.wordapp.WordAdapter
import com.ninesol.wordapp.databinding.ActivityWordsBinding
import com.ninesol.wordapp.viewmodel.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordsActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityWordsBinding
    private val wordsViewModel: WordsViewModel by viewModels()
    private lateinit var wordsAdapter: WordAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_words)
        setListener()
        wordsViewModel.getAllWords().observe(this) {
            wordsAdapter.submitList(it)
        }
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mBinding.wordsRecyclerView.apply {
            wordsAdapter = WordAdapter()
            layoutManager = LinearLayoutManager(this@WordsActivity)
            adapter = wordsAdapter
        }
    }

    private fun setListener() {
        mBinding.addWordFab.setOnClickListener {
            showAddWordDialog()
        }
    }

    @SuppressLint("CheckResult")
    private fun showAddWordDialog() {
        MaterialDialog(this).show {
            input { dialog, text ->
                wordsViewModel.saveWord(text.toString()).observe(this@WordsActivity) {
                    if (it) {
                        Toast.makeText(this@WordsActivity, "success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@WordsActivity, "success", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            positiveButton(text = "Submit")
        }
    }
}