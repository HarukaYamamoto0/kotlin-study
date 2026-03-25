package com.harukadev.intermediate

fun main() {
    render {
        drawCircle()
        drawSquare()
    }
    val menu = createMenu("vegetarian") {
        addItem("salad")
        addItem("brown bread")
        println("dasd")
    }
    println(menu.items.joinToString(",") { it.name })

    val button = Button()

    button.onEvent {
        if (!isRightClick && amount == 2) {
            println("Double click!")
        }
    }

    val originalList = listOf(1, 2, 3)
    val newList = originalList.incremented()
    println(newList)

    val greekAlphabet = listOf("Alpha", "Beta", "gamma")

    val string = buildString2 {
        appendLine("Alphabet:")
        for (alpha in greekAlphabet) appendLine(alpha)
    }

    println(string)

    val site = div {
        p { "Hello" }
        p { "World" }
    }
    println(site)

    val result = Pipeline(10).pipe { transform { it * 2 } }.pipe { transform { it + 3 } }.result // 23

    println(result)

    val validator = Validator<String> {
        rule("must not be blank") { it.isNotBlank() }
        rule("min 3 chars") { it.length >= 3 }
    }

    println(validator.validate("").joinToString(","))
    println(validator.validate("ab").joinToString(","))
    println(validator.validate("abc").joinToString(","))

    val result2 = "  hello  "
        .myLet { it.trim() }
        .myLet { it.uppercase() }

    println(result2)

    val list = mutableListOf<Int>()
        .myAlso { it.add(1) }
        .myAlso { it.add(2) }

    println(list)

    val sb = StringBuilder()
        .myApply { append("hello") }
        .myApply { append(" world") }

    println(sb)
}

class Canvas2 {
    fun drawCircle() = println("🟠 Drawing a circle")
    fun drawSquare() = println("🟥 Drawing a square")
}

fun render(block: Canvas2.() -> Unit): Canvas2 {
    val canvas = Canvas2()
    canvas.block()
    return canvas
}

class MenuItem(val name: String)

class Menu(val name: String) {
    val items = mutableListOf<MenuItem>()

    fun addItem(name: String) {
        items.add(MenuItem(name))
    }
}


fun createMenu(name: String, method: Menu.() -> Unit): Menu {
    val menu = Menu(name)
    menu.method()
    return menu
}


class Button {
    fun onEvent(action: ButtonEvent.() -> Unit) {
        // Simulate a double-click event (not a right-click)
        val event = ButtonEvent(isRightClick = false, amount = 2, position = Position(100, 200))
        event.action() // Trigger the event callback
    }
}

data class ButtonEvent(
    val isRightClick: Boolean, val amount: Int, val position: Position
)

data class Position(
    val x: Int, val y: Int
)

fun List<Int>.incremented(): List<Int> {
    val originalList = this
    return buildList {
        for (item in originalList) add(item + 1)
    }
}

inline fun buildString2(block: StringBuilder.() -> Unit): String {
    val string = StringBuilder()
    string.block()
    return string.toString()
}

class HtmlTag(val tag: String) {
    val children = mutableListOf<String>()

    fun p(block: () -> String) {
        children.add("<p>${block()}</p>")
    }
}

fun div(block: HtmlTag.() -> Unit): String {
    val html = HtmlTag("div")
    html.block()
    return "<${html.tag}>\n\t${html.children.joinToString("\n\t")}\n</${html.tag}>"
}

class Pipeline<T>(private val value: T) {
    var result: T = value

    fun pipe(block: Pipeline<T>.() -> Pipeline<T>): Pipeline<T> {
        return this.block()
    }

    fun transform(block: (T) -> T): Pipeline<T> {
        return Pipeline(block(value))
    }
}

class Validator<T>(block: Validator<T>.() -> Unit) {
    private val rules = mutableListOf<Pair<String, (T) -> Boolean>>()

    init {
        this.block()
    }

    fun rule(description: String, block: (T) -> Boolean) {
        rules.add(description to block)
    }

    fun validate(value: T): List<String> {
        val result = mutableListOf<String>()

        for (rule in rules) {
            if (rule.second(value)) result.add(rule.first)
        }
        return result
    }
}

fun <T, R> T.myLet(block: (T) -> R): R {
    return block(this)
}

fun <T> T.myAlso(block: (T) -> Unit): T {
    block(this)
    return this
}

fun <T> T.myApply(block: T.() -> Unit): T {
    this.block()
    return this
}