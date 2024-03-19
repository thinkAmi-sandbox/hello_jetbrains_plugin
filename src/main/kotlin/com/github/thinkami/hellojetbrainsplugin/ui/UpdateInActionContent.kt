package com.github.thinkami.hellojetbrainsplugin.ui

import com.github.thinkami.hellojetbrainsplugin.actions.HeavyActionWithBackground
import com.github.thinkami.hellojetbrainsplugin.actions.HeavyActionWithoutBackground
import com.github.thinkami.hellojetbrainsplugin.actions.UpdateLabelAction
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.Cell
import com.intellij.ui.dsl.builder.panel
import java.awt.event.ActionEvent
import javax.swing.JLabel

class UpdateInActionContent {
    var contentPanel : DialogPanel
    lateinit var myLabel: Cell<JLabel>

    init {
        contentPanel = panel {
            row {
                myLabel = label("Initial content")
                myLabel.component.name = "myLabel"

                button("Run Function") { event -> handleClick(event) }
                button("Run Action", UpdateLabelAction())
            }

            row {
                label("Heavy actions")

                button("Heavy Action Without Background", HeavyActionWithoutBackground())
                button("Heavy Action With Background", HeavyActionWithBackground())
            }
        }
    }

    private fun handleClick(event: ActionEvent) {
        myLabel.component.text = "handle click"
    }
}