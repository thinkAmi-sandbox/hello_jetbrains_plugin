package com.github.thinkami.hellojetbrainsplugin.ui

import com.github.thinkami.hellojetbrainsplugin.actions.ShowPopupAction
import com.github.thinkami.hellojetbrainsplugin.actions.StatusBarMessageAction
import com.github.thinkami.hellojetbrainsplugin.actions.ToolWindowNotificationAction
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.ui.Messages
import com.intellij.ui.dsl.builder.panel
import java.awt.event.ActionEvent

class NotificationContent {
    var contentPanel : DialogPanel

    init {
        contentPanel = panel {
            row {
                button("Message Dialog") { event -> handleMessageDialog(event)}
            }

            row {
                button("Custom Dialog") { event -> handleCustomDialog(event) }
            }

            row {
                button("Popup", ShowPopupAction())
            }

            row {
                button("Notification Bus") { event -> handleNotificationBus(event) }
            }

            row {
                button("Tool Window Notification", ToolWindowNotificationAction())
            }

            row {
                button("Status Bar", StatusBarMessageAction())
            }
        }
    }

    private fun handleMessageDialog(event: ActionEvent) {
        // showMessageDialogの場合、改行文字を使えば改行される
        Messages.showMessageDialog("Message with Message Dialog. \n Hello world", "Dialog Title", Messages.getInformationIcon())
    }

    private fun handleCustomDialog(event: ActionEvent) {
        CustomNotificationDialog().show()
    }

    private fun handleNotificationBus(event: ActionEvent) {
        val notification = Notification(
            "notificationGroupId",
            "Notification Bus Title",
            "Message with Notification Bus <br> Hello world", // \n ではなく <br> タグで改行できる
            NotificationType.INFORMATION)
        Notifications.Bus.notify(notification)
    }
}