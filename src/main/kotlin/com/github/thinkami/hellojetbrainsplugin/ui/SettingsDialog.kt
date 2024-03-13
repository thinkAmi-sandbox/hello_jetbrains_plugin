package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class SettingsDialog: DialogWrapper(true) {
    init {
        title = "My Settings"
        init()
    }

    override fun createCenterPanel(): JComponent {
        return panel {
            row {
                label("Hello")
            }
        }
    }
}