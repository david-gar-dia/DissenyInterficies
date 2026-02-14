package cat.montilivi.data.interfaces

import cat.montilivi.model.Entity

interface IEntityDao {
    fun insereix (entity: Entity): Boolean
    fun actualitza (entity: Entity): Boolean
    fun elimina (id: Int): Boolean
    fun obtenPerID (id: Int): Entity?
    fun obtenTots() : List<Entity>
}