package org.hexworks.zircon.examples

import org.hexworks.zircon.api.*
import org.hexworks.zircon.api.color.TileColor
import org.hexworks.zircon.api.modifier.FadeIn
import org.hexworks.zircon.api.modifier.FadeOut
import org.hexworks.zircon.api.resource.ColorThemeResource

object FadeInOutExample {

    private val tileset = CP437TilesetResources.taffer20x20()

    @JvmStatic
    fun main(args: Array<String>) {

        val tileGrid = SwingApplications.startTileGrid(AppConfigs.newConfig()
                .withDefaultTileset(tileset)
                .withSize(Sizes.create(60, 10))
                .withDebugMode(true)
                .build())

        val text = "This text fades in and then after a few seconds out"

        tileGrid.putCursorAt(Positions.create(1, 1))
        text.forEach { c ->
            tileGrid.putTile(Tiles.defaultTile()
                    .withBackgroundColor(TileColor.transparent())
                    .withForegroundColor(ColorThemeResource.NORD.getTheme().accentColor)
                    .withCharacter(c)
                    .withModifiers(Modifiers.fadeInOut()))
        }

    }

}












