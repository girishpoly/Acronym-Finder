package com.acronymtest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    public val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel()
    }

    @Test
    fun searchTextTest() {
        val resultFalse = viewModel.searchText("")
        Assert.assertEquals(resultFalse, false)
        val resultTrue = viewModel.searchText("FBI")
        Assert.assertEquals(resultTrue, true)
    }

    @Test
    fun watchTextTest() {
        val resultTrue = viewModel.watchText("")
        Assert.assertEquals(resultTrue, true)
    }

}

