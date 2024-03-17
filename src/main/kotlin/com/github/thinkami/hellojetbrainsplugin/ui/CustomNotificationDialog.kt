package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class CustomNotificationDialog: DialogWrapper(true) {
    init {
        title = "Custom Dialog Title"

        init()
    }

    override fun createCenterPanel(): JComponent {
        return panel {
            row {
                // https://stackoverflow.com/a/1090112
                label("<html>Dialog message <br> Hello world</html>")
            }
        }
    }
}