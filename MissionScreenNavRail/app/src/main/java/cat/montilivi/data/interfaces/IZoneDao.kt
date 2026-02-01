package cat.montilivi.data.interfaces

import cat.montilivi.model.Zone

interface IZoneDao {
    fun insereix (zone: Zone): Boolean
    fun actualitza (zone: Zone): Boolean
    fun elimina (id: Int): Boolean
    fun obtenPerID (id: Int): Zone?
    fun obtenTots() : List<Zone>
}