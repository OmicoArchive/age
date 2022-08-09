package me.omico.age.project.xml

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias Attributes = Map<String, String>

interface AttributesScope {
    fun <Value : Any> attribute(key: String, value: Value)
}

internal class AttributesBuilder : AttributesScope, Builder<Attributes> {
    private val attributes: MutableMap<String, String> = mutableMapOf()
    override fun <Value : Any> attribute(key: String, value: Value) {
        require(!attributes.containsKey(key)) { "Attribute [$key] already exists." }
        attributes[key] = value.toString()
    }

    override fun build(): Attributes = attributes
}

internal open class AttributesDelegate<T> : ReadWriteProperty<AttributesScope, T> {
    override fun getValue(thisRef: AttributesScope, property: KProperty<*>): T =
        throw UnsupportedOperationException()

    override operator fun setValue(thisRef: AttributesScope, property: KProperty<*>, value: T) {
        thisRef.attribute(property.name, value.toString())
    }
}
