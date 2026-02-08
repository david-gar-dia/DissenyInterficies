package cat.montilivi.data.impl

import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.interfaces.IZoneDao
import cat.montilivi.model.DecomposedColor
import cat.montilivi.model.Entity
import cat.montilivi.model.Zone
import cat.montilivi.model.enums.BiomeType
import cat.montilivi.model.enums.DangerLevel
import cat.montilivi.model.enums.Origin

object implDaoZoneInMemory: IZoneDao {

    var id: Int = 1;
    val dades: MutableList<Zone> = mutableListOf(
        Zone(1, "https://picsum.photos/1200/600", DecomposedColor(243, 70, 115), "Valley of Promises", "A small place to the side of Resembool", BiomeType.VALLEY, DangerLevel.NORMAL, true, false, true, 9, mutableListOf(2, 6, 12, 14, 16, 18, 20, 27, 31)),
        Zone(2, "https://picsum.photos/1200/600", DecomposedColor(98, 71, 176), "Beach of Peace", "A small place to the side of East City", BiomeType.BAY, DangerLevel.SAFE, false, false, true, 15, mutableListOf(19, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 44, 49, 50, 51)),
        Zone(3, "https://picsum.photos/1200/600", DecomposedColor(226, 23, 116), "Viridi's Land of Adventure", "A small place to the side of Riviere", BiomeType.FOREST, DangerLevel.NORMAL, true, false, true, 12, mutableListOf(3, 5, 9, 23, 25, 28, 36, 43, 45, 46, 47, 48)),
        Zone(4, "https://picsum.photos/1200/600", DecomposedColor(100, 139, 188), "Demise of Broken Bones", "A small place to the side of Riviere", BiomeType.DUNGEON, DangerLevel.DANGEROUS, true, true, true, 7, mutableListOf(4, 8, 11, 13, 15, 17, 22)),
        Zone(5, "https://picsum.photos/1200/600", DecomposedColor(3, 3, 204), "Territory of Broken Bones", "A small place to the side of East City", BiomeType.JUNGLE, DangerLevel.DANGEROUS, true, true, true, 8, mutableListOf(1, 7, 10, 21, 24, 26, 29, 30)),
    )

    val NamesPerBiome = mapOf<BiomeType, List<String>>(
        BiomeType.INDOORS to listOf("Moe's", "The Castle", "The Church", "Refugee's Shelter"),
        BiomeType.TOWN to listOf("Zawn", "Gerudo", "Termina", "Ciphadel", "Magna"),
        BiomeType.VALLEY to listOf("Valley", "Odin's Garden", "Vastness"),
        BiomeType.FOREST to listOf("Forest", "Viridi's Land", "The Greens"),
        BiomeType.JUNGLE to listOf("Depths", "Jungle", "Territory"),
        BiomeType.BAY to listOf("Bay", "Sea", "Beach"),
        BiomeType.FORTRESS to listOf("Fortress", "Palace", "The Force"),
        BiomeType.DUNGEON to listOf("Maze", "Dungeon", "Demise", "Ruins"),
        BiomeType.ISLAND to listOf("Island", "Land", "Poseidon's Shelter"),
        BiomeType.DESERT to listOf("Arid Lands", "Desert", "Vanna's Battlefield"),
        BiomeType.CAVE to listOf("Mouth", "Cave", "Caverns", "Haephestus' Lair", "The Forge"),
        BiomeType.VOLCANO to listOf("Volcano", "Hot-Lands", "Dragon's House", "Core", "Mountain")
    )
    val AdjectivesPerDanger = mapOf<DangerLevel, List<String>>(
        DangerLevel.SAFE to listOf("Calm", "Love", "Quiet", "Peace", "Protection"),
        DangerLevel.NORMAL to listOf("Ambition", "Wonders", "Adventure", "Promises"),
        DangerLevel.DANGEROUS to listOf("Danger", "Fire", "War", "Broken Bones", "Death"),
        DangerLevel.EXTREME to listOf("Extinction", "Apocalypse", "The Devil", "Massacre", "Certain Death")
    )
    val DangerLevelsPerBiome = mapOf<BiomeType, List<DangerLevel>>(
        BiomeType.INDOORS to listOf(DangerLevel.SAFE),
        BiomeType.TOWN to listOf(DangerLevel.SAFE, DangerLevel.NORMAL),
        BiomeType.VALLEY to listOf(DangerLevel.SAFE, DangerLevel.NORMAL, DangerLevel.DANGEROUS),
        BiomeType.FOREST to listOf(DangerLevel.SAFE, DangerLevel.NORMAL, DangerLevel.DANGEROUS, DangerLevel.EXTREME),
        BiomeType.JUNGLE to listOf(DangerLevel.DANGEROUS, DangerLevel.EXTREME),
        BiomeType.BAY to listOf(DangerLevel.SAFE, DangerLevel.NORMAL, DangerLevel.DANGEROUS),
        BiomeType.FORTRESS to listOf(DangerLevel.NORMAL, DangerLevel.DANGEROUS, DangerLevel.EXTREME),
        BiomeType.DUNGEON to listOf(DangerLevel.NORMAL, DangerLevel.DANGEROUS, DangerLevel.EXTREME),
        BiomeType.ISLAND to listOf(DangerLevel.SAFE, DangerLevel.NORMAL, DangerLevel.DANGEROUS),
        BiomeType.DESERT to listOf(DangerLevel.NORMAL, DangerLevel.DANGEROUS, DangerLevel.EXTREME),
        BiomeType.CAVE to listOf(DangerLevel.DANGEROUS, DangerLevel.EXTREME),
        BiomeType.VOLCANO to listOf(DangerLevel.EXTREME)
    )

//    fun calculateNumberOfEntities(biomeType: BiomeType, dangerLevel: DangerLevel): Int {
//        var numberOfEntities : Int;
//        var rateOfEntities : Int = 15;
//
//        when(biomeType) {
//            BiomeType.INDOORS -> {}
//            BiomeType.TOWN -> {}
//            BiomeType.VALLEY -> {
//                rateOfEntities -= 2;
//            }
//            BiomeType.FOREST -> {
//                rateOfEntities -= 3;
//            }
//            BiomeType.JUNGLE -> {
//                rateOfEntities -= 6;
//            }
//            BiomeType.BAY -> {
//                rateOfEntities -= 4;
//            }
//            BiomeType.FORTRESS -> {
//                rateOfEntities -= 7;
//            }
//            BiomeType.DUNGEON -> {
//                rateOfEntities -= 7;
//            }
//            BiomeType.ISLAND -> {
//                rateOfEntities -= 4;
//            }
//            BiomeType.DESERT -> {
//                rateOfEntities -= 7;
//            }
//            BiomeType.CAVE -> {
//                rateOfEntities -= 8;
//            }
//            BiomeType.VOLCANO -> {
//                rateOfEntities -= 10;
//            }
//        }
//
//        when(dangerLevel) {
//            DangerLevel.SAFE -> {}
//            DangerLevel.NORMAL -> {
//                rateOfEntities = (rateOfEntities/1.5).toInt();
//            }
//            DangerLevel.DANGEROUS -> {
//                rateOfEntities = rateOfEntities/2;
//            }
//            DangerLevel.EXTREME -> {
//                rateOfEntities = rateOfEntities/3;
//            }
//        }
//
//        numberOfEntities = Random.nextInt(1 + rateOfEntities, 5 + rateOfEntities);
//
//        return numberOfEntities;
//    }
//
//    fun generateZone() : Zone {
//        val faker : Faker = Faker();
//        val id: Int = this.id;
//        val name : String;
//        val description : String;
//        var nounSegment : String;
//        var adjectiveSegment : String;
//        val biome : BiomeType;
//        val danger : DangerLevel;
//        val isCombatEnabled: Boolean;
//        val willItemsBeLost: Boolean;
//        val isRespawnAvailable: Boolean;
//        val numEntities: Int;
//
//        description = "A small place to the side of " + faker.fullMetalAlchemist().city();
//
//        biome = BiomeType.entries.get(Random.nextInt(0, BiomeType.entries.size));
//        danger = DangerLevelsPerBiome[biome]!!.get(Random.nextInt(0, DangerLevelsPerBiome[biome]!!.size));
//
//        nounSegment = NamesPerBiome[biome]!!.get(Random.nextInt(0, NamesPerBiome[biome]!!.size));
//
//        if(biome != BiomeType.INDOORS)
//        {
//            adjectiveSegment = AdjectivesPerDanger[danger]!!.get(Random.nextInt(0, AdjectivesPerDanger[danger]!!.size));
//
//            name = nounSegment + " of " + adjectiveSegment;
//        }
//        else
//            name = nounSegment;
//
//        when(danger) {
//            DangerLevel.SAFE -> {
//                isCombatEnabled = false;
//                willItemsBeLost = false;
//                isRespawnAvailable = true;
//            }
//            DangerLevel.NORMAL -> {
//                isCombatEnabled = true;
//                willItemsBeLost = false;
//                isRespawnAvailable = true;
//            }
//            DangerLevel.DANGEROUS -> {
//                isCombatEnabled = true;
//                willItemsBeLost = true;
//                isRespawnAvailable = true;
//            }
//            DangerLevel.EXTREME -> {
//                isCombatEnabled = true;
//                willItemsBeLost = true;
//                isRespawnAvailable = false;
//            }
//        }
//
//        numEntities = calculateNumberOfEntities(biome, danger);
//
//        this.id++;
//
//        return Zone(
//            id,
//            "https://picsum.photos/400/200",
//            DecomposedColor(),
//            name,
//            description,
//            biome,
//            danger,
//            isCombatEnabled,
//            willItemsBeLost,
//            isRespawnAvailable,
//            numEntities,
//            mutableListOf()
//        )
//    }

    override fun insereix(zone: Zone): Boolean {
        var result: Boolean = true;

        if(dades.any{it.id == zone.id})
            result = false;
        else
            dades.add(zone);

        return result;
    }

    override fun actualitza(zone: Zone): Boolean {
        var result: Boolean = true;
        val position = dades.indexOfFirst { it.id == zone.id }
        if(position < 0)
            result = false;
        else
            dades[position] = zone;

        return result;
    }

    override fun elimina(id: Int): Boolean {
        var result: Boolean = true;
        val position = dades.indexOfFirst { it.id == id }
        val entityDaoImpl = factoryDaoEntities.createDao(Origin.MEMORY);
        val dataEntity: List<Entity>;

        dataEntity = entityDaoImpl.obtenTots();
        if (position < 0)
            result = false;
        else {
            dades.removeAt(position);
            dataEntity.filter { n -> n.currentZoneLocation == id }.forEach {
                entityDaoImpl.elimina(it.id);
            }
        }

        return result;
    }

    override fun obtenPerID(id: Int): Zone? {
        return dades.firstOrNull{id == it.id}
    }

    override fun obtenTots(): List<Zone> {
        return dades.toList();
    }

}

