package com.curso.android.app.practica.ejerciciofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.ejerciciofinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparadorTextos.value?.text1
        assertEquals(null, value)
    }

    @Test
    fun mainViewModel_TestResult() = runTest {
        launch {
            viewModel.compareTextos("hola","hola")
        }
        advanceUntilIdle()
        val value = viewModel.comparadorTextos.value?.sonIguales
        assertSame(true, value)
    }
}