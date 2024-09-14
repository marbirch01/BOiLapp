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
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostFifthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostFirstStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostFourthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostSecondStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostSeventhStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostSixthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost.CpmCostThirdStep
import pl.marbirch.boilapp.ui.screens.open_tasks.IncorrectCpmCostAnswer
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.DoapFifthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.DoapFirstStep
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.DoapFourthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.DoapSecondStep
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.DoapSixthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.DoapThirdStep
import pl.marbirch.boilapp.ui.screens.open_tasks.wiel.ZadWielFifthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.wiel.ZadWielFirstStep
import pl.marbirch.boilapp.ui.screens.open_tasks.wiel.ZadWielFourthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.wiel.ZadWielSecondStep
import pl.marbirch.boilapp.ui.screens.open_tasks.wiel.ZadWielSixthStep
import pl.marbirch.boilapp.ui.screens.open_tasks.wiel.ZadWielThirdStep
import pl.marbirch.boilapp.ui.screens.quiz.HistoryScreen
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
                },
                onHistory = {
                    navigationController.navigate(Roads.historyScreen)
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
        composable(Roads.historyScreen){
            val historyState by viewModel.currentHistoryState.collectAsState()
            HistoryScreen(quizHistoryList = historyState)
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
                onCpmCost = {navigationController.navigate(Roads.cpmCostFirstStep)},
                onDoap = {navigationController.navigate(Roads.doapFirstStep)},
                onOptPrzy = {navigationController.navigate(Roads.zadWielFirstStep)}
            )
        }

        //CPM
        composable(Roads.cpmFirstStep){
            CpmFirstStepScreen(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.cpmSecondStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmSecondStep){
            CpmSecondStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.cpmThirdStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmThirdStep){
            CpmThirdStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.cpmFourthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmFourthStep){
            CpmFourthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.cpmFifthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmFifthStep){
            CpmFifthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.FinishedOpenTaskScreen)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }

        //CPM-COST
        composable(Roads.cpmCostFirstStep){
            CpmCostFirstStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostSecondStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmCostSecondStep){
            CpmCostSecondStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostThirdStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmCostThirdStep){
            CpmCostThirdStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostFourthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmCostFourthStep){
            CpmCostFourthStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostFifthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmCostFifthStep){
            CpmCostFifthStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostSixthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmCostSixthStep){
            CpmCostSixthStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.cpmCostSeventhStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.cpmCostSeventhStep){
            CpmCostSeventhStep(onCheckAns = {isCorrect ->
                if (isCorrect) {
                    navigationController.navigate(Roads.FinishedOpenTaskScreen)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.IncorrectOpenTaskAnswer){
            IncorrectCpmCostAnswer(onRetry = {
                navigationController.popBackStack()
            })
        }
        composable(Roads.FinishedOpenTaskScreen){
            FinishedOpenTaskScreen(onEnd = {
                navigationController.navigate(Roads.openTasksScreen)
            })
        }

        //Dobór optymalnego asortymentu produkcji
        composable(Roads.doapFirstStep){
            DoapFirstStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.doapSecondStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.doapSecondStep){
            DoapSecondStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.doapThirdStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.doapThirdStep){
            DoapThirdStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.doapFourthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.doapFourthStep){
            DoapFourthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.doapFifthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.doapFifthStep){
            DoapFifthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.doapSixthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.doapSixthStep){
            DoapSixthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.FinishedOpenTaskScreen)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }

        //Optymalizacja przychodów
        composable(Roads.zadWielFirstStep){
            ZadWielFirstStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.zadWielSecondStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.zadWielSecondStep){
            ZadWielSecondStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.zadWielThirdStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.zadWielThirdStep){
            ZadWielThirdStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.zadWielFourthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.zadWielFourthStep){
            ZadWielFourthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.zadWielFifthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.zadWielFifthStep){
            ZadWielFifthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.zadWielSixthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
        composable(Roads.zadWielSixthStep){
            ZadWielSixthStep(onCheckAns = {isCorrect ->
                if(isCorrect){
                    navigationController.navigate(Roads.FinishedOpenTaskScreen)
                }else{
                    navigationController.navigate(Roads.IncorrectOpenTaskAnswer)
                }
            })
        }
    }
}

