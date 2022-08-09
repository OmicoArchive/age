package me.omico.age.project.xml

data class Element(
    val name: String,
    val attributes: Attributes,
    val children: List<Element>,
)

interface ElementScope : AttributesScope {
    operator fun Element.unaryPlus()
}

fun element(name: String, builder: ElementScope.() -> Unit = {}): Element = ElementBuilder(name).apply(builder).build()

internal open class ElementBuilder(
    private val name: String,
    private val attributesBuilder: AttributesBuilder = AttributesBuilder(),
) : ElementScope,
    AttributesScope by attributesBuilder,
    Builder<Element> {

    private val _children: MutableList<Element> = mutableListOf()

    override fun Element.unaryPlus() {
        _children.add(this)
    }

    override fun build(): Element =
        Element(
            name = name,
            attributes = attributesBuilder.build(),
            children = _children,
        )
}
