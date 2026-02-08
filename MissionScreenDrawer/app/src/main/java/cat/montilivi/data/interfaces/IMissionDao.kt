package cat.montilivi.data.interfaces

import cat.montilivi.model.Mission

interface IMissionDao {
    fun insereix (entity: Mission): Boolean
    fun actualitza (entity: Mission): Boolean
    fun elimina (id: Int): Boolean
    fun obtenPerID (id: Int): Mission?
    fun obtenTots() : List<Mission>
}