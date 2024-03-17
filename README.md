# hello_jetbrains_plugin

![Build](https://github.com/thinkAmi-sandbox/hello_jetbrains_plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [ ] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [ ] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the `PLUGIN_ID` in the above README badges.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "hello_jetbrains_plugin"</kbd> >
  <kbd>Install</kbd>
  
- Manually:

  Download the [latest release](https://github.com/thinkAmi-sandbox/hello_jetbrains_plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation


## Related Blog (Written in Japanese)

- [IntelliJ Platform Plugin Templateを使って、「エディタのコンテキストメニューからダイアログを表示する」だけのJetBrains系IDEプラグインを作ってみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/02/21/232451)
- [IntelliJ Platform Plugin開発で、Kotlin UI DSL Version 2 や Swing を使って、ToolWindow上にコンポーネントを表示してみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/02/25/173458)
- [IntelliJ Platform Pluginの開発にて、RubyMineなどのIntelliJ IDEA以外のIDEがRun Pluginで起動するようにしてみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/02/27/230324)
- [IntelliJ Platform Pluginの開発にて、ApplicationManagerやToolWindowManagerを使って、Actionの中でToolWindow上のlabelを更新してみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/03/08/000506)
- [IntelliJ Platform Pluginの開発にて、ToolWindow上で、TextFieldの入力値に従って絞り込み可能なテーブル(JBTable)を表示してみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/03/09/232514)
- [IntelliJ Platform Pluginの開発にて、ToolWindow上で、CellRendererを使ってテーブル(JBTable)の列に画像を表示してみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/03/12/231534)
- [IntelliJ Platform Pluginの開発にて、ToolWindow上で、DialogWrapperとPropertiesComponentを使って、設定の保存と読み込みを行ってみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/03/14/001226)
- [IntelliJ Platform Pluginの開発にて、ToolWindow上で、テーブルの絞り込み条件入力で使うコンポーネントを SearchTextField にしてみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/03/14/204818)
- [IntelliJ Platform Pluginの開発にて、ToolWindow上で、Dialog・Balloon・StatusBarなどを使って改行ありのメッセージを表示してみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2024/03/17/103752)
