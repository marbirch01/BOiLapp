package pl.marbirch.boilapp.data.model.domain

sealed class CpmCostState {
    data class Step(val stepNumber: Int) : CpmCostState()
    data class IncorrectAnswer(val stepNumber: Int) : CpmCostState()
    object FinishedStep : CpmCostState()
}