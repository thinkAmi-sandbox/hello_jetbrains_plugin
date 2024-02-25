package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBRadioButton
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.table.JBTable
import java.awt.event.ActionListener
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.table.DefaultTableModel


fun getHelloContent(): JComponent {

    val data = arrayOf(
        arrayOf("1", "Fuji", "Red"),
        arrayOf("2", "Shinano Gold", "Yellow"),
        arrayOf("3", "Bramley", "Green")
    )

    val columnNames = arrayOf("ID", "Name", "Color")
    val tableModel = DefaultTableModel(data, columnNames)
    val table = JBTable(tableModel)
    val scrollableTablePanel = JBScrollPane(table)

    val p = panel {
        row {
            label("Hello")
        }

        // rowに引数あり
        row("With row args") {
            label("Row args")
        }

        separator()

        // インデントあり
        indent {
            row {
                label("Indented row")
            }
        }

        // DSLで用意されていないSWingコンポーネントを表示する場合はcellを使う：例えばtable
        separator()
        row {
            cell(scrollableTablePanel)
        }

        // enabledIf / visibleIf
        separator()

        // 別の定義のCellと参照がかぶるので、フルで型指定する
        lateinit var myCheckBox: com.intellij.ui.dsl.builder.Cell<JBCheckBox>
        row {
            myCheckBox = checkBox("Enable option if checked.")
            checkBox("Option by enable").enabledIf(myCheckBox.selected)
            checkBox("Option by visible").visibleIf(myCheckBox.selected)
        }

        // checkBox
        separator()

        lateinit var myCheckBoxForRowsRange: com.intellij.ui.dsl.builder.Cell<JBCheckBox>
        row {
            myCheckBoxForRowsRange = checkBox("Checkbox for multiple rows")
        }

        // rowsRangeなしの場合
        row {
            label("1st row label without rowsRange")
        }.visibleIf(myCheckBoxForRowsRange.selected)

        row {
            label("2nd row label without rowsRange")
        }.visibleIf(myCheckBoxForRowsRange.selected)

        // rowsRangeありの場合
        rowsRange {
            row {
                label("1st row label with rowsRange")
            }
            row {
                label("2nd row label with rowsRange")
            }
        }.visibleIf(myCheckBoxForRowsRange.selected)

        // buttonGroup系
        separator()

        lateinit var firstRadio: Cell<JBRadioButton>
        lateinit var secondRadio: Cell<JBRadioButton>
        var selectedRadioValue = "Default message"
        buttonsGroup("Select Radio Button") {
            row {
                firstRadio = radioButton("1st choice", "1st selected")
            }
            row {
                secondRadio = radioButton("2nd choice", "2nd selected")
            }
        }.bind( {selectedRadioValue}, { selectedRadioValue = it } ) // bindしないと表示できない

        lateinit var labelForRadioButton: Cell<JLabel>
        row {
            labelForRadioButton = label(selectedRadioValue)
        }

        val myListener = ActionListener { e ->
            val rb = e.source as JBRadioButton
            labelForRadioButton.component.text = rb.text
        }

        // Cell<JBRadioButton> 型なので、 component を使って <> の中を取り出す
        firstRadio.component.addActionListener(myListener)
        secondRadio.component.addActionListener(myListener)


        // グループ系
        // group
        separator()

        group("My Group Title") {
            row("1st row") {
                textField()
            }
            row("2nd row") {
                textField()
            }
        }

        group("Root Group") {
            row("Root row") { textField() }

            group("Nested Group") {
                row("Nested row") { textField() }
            }
        }

        // groupRowsRange系
        lateinit var groupCheckbox: com.intellij.ui.dsl.builder.Cell<JBCheckBox>
        row {
            groupCheckbox = checkBox("Checkbox for groups")
        }
        groupRowsRange {
            group("1st Group") {
                row("1st row") { textField() }
            }
            group("2nd Group") {
                row("2nd row") { textField() }
            }
        }.visibleIf(groupCheckbox.selected)

        // collapsibleGroup系
        separator()

        // デフォルトだと、最初は閉じている
        collapsibleGroup("Collapsible Group") {
            group("My Group") {
                row("My row") { textField() }
            }
        }

        // 最初から開いておく
        collapsibleGroup("Collapsible Open Group") {
            group("Open Group") {
                row("Open row") { textField() }
            }
        }.expanded = true

        // .comment系
        separator()
        row {
            label("With comment").comment("My comment")
        }

        row {
            // .text() で textField のデフォルト値を設定する
            textField().comment("Text field comment").text("text property")
        }

        row("Row args") {
            textField().comment("Text field comment").text("text property")
        }

        row {
            label("Label args")
            textField().comment("Text field comment").text("text property")
        }


        // ------------------------------------
        // レイアウト系
        // ------------------------------------
        // topGap
        separator()

        row {
            label("Default top gap")
        }

        row {
            label("Small top gap")
        }.topGap(TopGap.SMALL)

        row {
            label("Medium top gap")
        }.topGap(TopGap.MEDIUM)

        // align系
        separator()

        row {
            label("With alignY-Top").align(AlignY.TOP)
            textField()
        }

        row {
            label("With alignX and alignY").align(AlignX.RIGHT).align(AlignY.BOTTOM)
            textField()
        }

        // resizableColumn系
        separator()

        row("Without Resizable Column") {
            textField()
            link("My link") {}
        }
        row("With Resizable Column") {
            textField().resizableColumn()
            link("My link") {}
        }

        // gap系
        separator()

        row {
            label("Gap nothing")
            textField()
        }

        row {
            label("Gap small__").gap(RightGap.SMALL)
            textField()
        }

        row {
            label("Gap columns").gap(RightGap.COLUMNS)
            textField()
        }


        // Row.Layout系
        separator()

        // rowに引数がある場合
        row("Row args") {
            textField().text("default")
        }

        row("Row args") {
            textField().text("independent")
        }.layout(RowLayout.INDEPENDENT)

        row("Row args") {
            textField().text("label aligned")
        }.layout(RowLayout.LABEL_ALIGNED)

        row("Row args") {
            textField().text("parent grid")
        }.layout(RowLayout.PARENT_GRID)

        // rowに引数はないが、labelコンポーネントがある場合
        row {
            label("Label args")
            textField().text("default")
        }

        row {
            label("Label args")
            textField().text("independent")
        }.layout(RowLayout.INDEPENDENT)

        row {
            label("Label args")
            textField().text("label aligned")
        }.layout(RowLayout.LABEL_ALIGNED)

        row {
            label("Label args")
            textField().text("parent grid")
        }.layout(RowLayout.PARENT_GRID)


        // LabelPosition系
        separator()

        row {
            textField().label("Cell label")
        }
        row {
            textField().label("Cell label", LabelPosition.TOP)
        }
        row {
            textField().label("Cell label", LabelPosition.LEFT)
        }

        // columns系
        separator()

        row {
            textField().columns(COLUMNS_TINY)
        }
        row {
            textField().columns(COLUMNS_SHORT)
        }
        row {
            textField().columns(COLUMNS_MEDIUM)
        }
        row {
            textField().columns(COLUMNS_LARGE)
        }
    }

    return JBScrollPane(p)
}