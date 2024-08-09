package pl.marbirch.boilapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.marbirch.boilapp.data.model.domain.MenuEvents
import pl.marbirch.boilapp.data.model.domain.QuizEvents
import pl.marbirch.boilapp.ui.roads.Roads
import pl.marbirch.boilapp.ui.screens.open_tasks.FinishedOpenTaskScreen
import pl.marbirch.boilapp.ui.screens.open_tasks.SelectOpenTaskScreen
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.CpmFifthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.CpmFirstStepScreen
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.CpmSecondStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.CpmThirdStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.CpmFourthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.IncorrectCpmFifthAnswer
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.IncorrectCpmFirstAnswer
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.IncorrectCpmFourthAnswer
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.IncorrectCpmSecondAnswer
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm.IncorrectCpmThirdAnswer
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostFifthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostFirstStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostFourthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostSecondStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostSeventhStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostSixthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostThirdStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.IncorrectCpmCostAnswer
import pl.marbirch.boilapp.ui.screens.quiz.QuizScreen
import pl.marbirch.boilapp.ui.screens.quiz.StartScreen
import pl.marbirch.boilapp.ui.screens.theory.CpmCostMethod
import pl.marbirch.boilapp.ui.screens.theory.CpmMethod
import pl.marbirch.boilapp.ui.screens.theory.DoapMethod
import pl.marbirch.boilapp.ui.screens.theory.OptRozMethod
import pl.marbirch.boilapp.ui.theme.BOiLappTheme
import pl.marbirch.boilapp.ui.screens.theory.SelectTheoryScreen
import pl.marbirch.boilapp.ui.screens.theory.ZadWielMethod

class MainActivity : ComponentActivity() { 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainVm = viewModel(modelClass = MainViewModel::class.java)
            MainApplication(viewModel = mainVm)
        }
    }
}

@Composable
fun MainApplication(viewModel: MainViewModel) {
    BOiLappTheme {
        val navigationController = rememberNavController()
        NavigationAppHost(viewModel = viewModel, navigationController = navigationController)
    }
}

@Composable
fun NavigationAppHost(modifier: Modifier = Modifier, viewModel: MainViewModel, navigationController: NavHostController) {
    NavHost(modifier = modifier, navController = navigationController, startDestination = Roads.startScreen){
        composable(Roads.startScreen){
            StartScreen(
                onQuiz = {
                    viewModel.menuEventHandler(MenuEvents.Quiz)
                    navigationController.navigate(Roads.quizScreen)
                },
                onTheory = {
                    viewModel.menuEventHandler(MenuEvents.Theory)
                    navigationController.navigate(Roads.theoryScreen)
                },
                onOpenTasks = {
                    viewModel.menuEventHandler(MenuEvents.OpenTasks)
                    navigationController.navigate(Roads.openTasksScreen)
                }
            )
        }
        composable(Roads.quizScreen){
            val state by viewModel.currentQuizState.collectAsState()
            QuizScreen(
                quizState = state,
                onCheck = {answer ->
                    val event = QuizEvents.CheckAns(answer)
                    viewModel.quizEventHandler(event)
                },
                onNext = {answer ->
                    val event = QuizEvents.NextQue(
                        correctAnsweredQuestions = answer.correctAnsweredQuestions,
                        displayedQuestions = answer.displayedQuestions
                    )
                    viewModel.quizEventHandler(event)
                },
                onFinish = {
                    navigationController.navigate(Roads.startScreen){
                        popUpTo(navigationController.graph.startDestinationId){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Roads.theoryScreen){
            SelectTheoryScreen(
                onCpm = {
                    navigationController.navigate(Roads.cpmMethod)
                },
                onCpmCost = {
                    navigationController.navigate(Roads.cpmCostMethod)
                },
                onDoap = {
                    navigationController.navigate(Roads.doapMethod)
                },
                onOptRoz = {
                    navigationController.navigate(Roads.optRozMethod)
                },
                onOptPrzy = {
                    navigationController.navigate(Roads.zadWielMethod)
                }
            )
        }
        composable(Roads.cpmMethod){
            CpmMethod()
        }
        composable(Roads.cpmCostMethod){
            CpmCostMethod()
        }
        composable(Roads.doapMethod){
            DoapMethod()
        }
        composable(Roads.optRozMethod){
            OptRozMethod()
        }
        composable(Roads.zadWielMethod){
            ZadWielMethod()
        }
        composable(Roads.openTasksScreen){
            SelectOpenTaskScreen(
                onCpm = { navigationController.navigate(Roads.cpmFirstStep) },
                onCpmCost = {navigationController.navigate(Roads.cpmCostFirstStep)}
            )
        }
        composable(Roads.cpmFirstStep){
            CpmFirstStepScreen(navigationController = navigationController)
        }
        composable(Roads.cpmSecondStep){
            CpmSecondStep(navigationController = navigationController)
        }
        composable(Roads.cpmThirdStep){
            CpmThirdStep(navigationController = navigationController)
        }
        composable(Roads.cpmFourthStep){
            CpmFourthStep(navigationController = navigationController)
        }
        composable(Roads.cpmFifthStep){
            CpmFifthStep(navigationController = navigationController)
        }
        composable(Roads.IncorrectCpmFirstAnswer){
            IncorrectCpmFirstAnswer(navigationController = navigationController)
        }
        composable(Roads.IncorrectCpmSecondAnswer){
            IncorrectCpmSecondAnswer(navigationController = navigationController)
        }
        composable(Roads.IncorrectCpmThirdAnswer){
            IncorrectCpmThirdAnswer(navigationController = navigationController)
        }
        composable(Roads.IncorrectCpmFourthAnswer){
            IncorrectCpmFourthAnswer(navigationController = navigationController)
        }
        composable(Roads.IncorrectCpmFifthAnswer){
            IncorrectCpmFifthAnswer(navigationController = navigationController)
        }

        composable(Roads.cpmCostFirstStep){
            CpmCostFirstStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostSecondStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.cpmCostSecondStep){
            CpmCostSecondStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostThirdStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.cpmCostThirdStep){
            CpmCostThirdStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostFourthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.cpmCostFourthStep){
            CpmCostFourthStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostFifthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.cpmCostFifthStep){
            CpmCostFifthStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostSixthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.cpmCostSixthStep){
            CpmCostSixthStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostSeventhStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.cpmCostSeventhStep){
            CpmCostSeventhStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.FinishedOpenTaskScreen)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmCostAnswer)
                }
            })
        }
        composable(Roads.IncorrectCpmCostAnswer){
            IncorrectCpmCostAnswer(onRetry = {
                navigationController.popBackStack()
            })
        }
        composable(Roads.FinishedOpenTaskScreen){
            FinishedOpenTaskScreen(onRetry = {
                navigationController.navigate(Roads.openTasksScreen)
            })
        }
    }
}

