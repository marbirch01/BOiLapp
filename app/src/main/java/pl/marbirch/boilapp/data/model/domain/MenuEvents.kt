package pl.marbirch.boilapp.data.model.domain

sealed class MenuEvents {
    data object Quiz : MenuEvents()
    data object Theory : MenuEvents()
    data object OpenTasks : MenuEvents()
}