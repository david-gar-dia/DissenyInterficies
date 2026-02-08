package cat.montilivi.data.impl

import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.data.interfaces.IEntityDao
import cat.montilivi.model.DecomposedColor
import cat.montilivi.model.Entity
import cat.montilivi.model.Mission
import cat.montilivi.model.Zone
import cat.montilivi.model.enums.EntityType
import cat.montilivi.model.enums.Origin

object implDaoEntityInMemory : IEntityDao {

    var id: Int = 1;
    val dades: MutableList<Entity> = mutableListOf(
        Entity(1, "https://picsum.photos/400", DecomposedColor(79, 198, 158), "Ansaulme de Rougecarpe Tor'no", "Literally Kassadin from League of Legends", EntityType.ALLY, "Heart-Bound", "Citizen", "Bow", listOf("Musical Talent", "Earth Affinity", "Endurance", ), listOf("Fragile Ego", "Poor Balance", ), 6, 7, 10, 5, 6, 5, mutableListOf(81, 130, 136)),
        Entity(2, "https://picsum.photos/400", DecomposedColor(123, 8, 87), "Aoba Yamashiro Jaelec", "Literally Xayah from League of Legends", EntityType.ENEMY, "Chaotic", "Monster", "Magma Axe", listOf("Ritual Casting", "Earthshaping", "Charm and Seduction", ), listOf("Dependent on Host Form", "Weak Against Silver Weapons", ), 7, 8, 8, 6, 10, 1, mutableListOf(44, 68, 108)),
        Entity(3, "https://picsum.photos/400", DecomposedColor(7, 230, 7), "Ike Redta", "Literally Graves from League of Legends", EntityType.ENEMY, "Normal", "Wild Animal", "Magma Cannon", listOf("Dimension Walking", "Venom Secretion", "Fear Induction", ), listOf("Susceptible to Sound-based Attacks", "Fear of Silence", ), 5, 7, 5, 5, 7, 3, mutableListOf(14, 104, 124)),
        Entity(4, "https://picsum.photos/400", DecomposedColor(173, 143, 245), "Daichi Chefury", "Literally Trundle from League of Legends", EntityType.ENEMY, "Normal", "Archdemon", "Book", listOf("Lightning Affinity", "Telepathy", "Shadow Weaving", ), listOf("Blood Dependency", "Overconfident in Power", ), 20, 18, 15, 15, 19, 4, mutableListOf(77, 83, 97)),
        Entity(5, "https://picsum.photos/400", DecomposedColor(196, 150, 196), "Phaedra", "Literally Kayle from League of Legends", EntityType.ULTERIOR_BEING, "Mind-Bound", "Throne", "Will of the Big-One", listOf("Devotion", ), listOf("Blasphemy", ), 14, 16, 11, 12, 13, 3, mutableListOf(7, 17, 34)),
        Entity(6, "https://picsum.photos/400", DecomposedColor(191, 146, 252), "Ch?ji Akimichi Tor'no", "Literally Ashe from League of Legends", EntityType.ALLY, "Healing", "Captain", "Hope Claws", listOf("Strategy and Tactics", "Agility", "Arcane Knowledge", ), listOf("Vulnerable to Dark Magic", "Na�ve Compassion", "Easily Fatigued", ), 11, 12, 12, 16, 11, 1, mutableListOf(84, 111, 115)),
        Entity(7, "https://picsum.photos/400", DecomposedColor(165, 237, 78), "Andromache", "Literally Swain from League of Legends", EntityType.ULTERIOR_BEING, "Ambitious", "God", "Shock of the Abyss", listOf("Devotion", ), listOf("Blasphemy", ), 24, 25, 23, 24, 21, 5, mutableListOf(15, 43, 45)),
        Entity(8, "https://picsum.photos/400", DecomposedColor(59, 223, 231), "Palutena Tor'no", "Literally Kalista from League of Legends", EntityType.ALLY, "Normal", "Elite", "Hope Staff", listOf("Shield Mastery", "Wind Manipulation", "Tactical Foresight", ), listOf("Reckless in Combat", "Impulsive Decisions", "Poor Orientation", ), 19, 16, 18, 19, 15, 4, mutableListOf(9, 140, 145)),
        Entity(9, "https://picsum.photos/400", DecomposedColor(53, 192, 192), "D?shin Lorlant", "Literally Zoe from League of Legends", EntityType.ENEMY, "Void-Consumed", "Archdemon", "Knuckles", listOf("Mana Overload", "Demonic Endurance", ), listOf("Easily Angered", "Cannot Cross Running Water", ), 18, 18, 16, 18, 19, 3, mutableListOf(1, 63, 70)),
        Entity(10, "https://picsum.photos/400", DecomposedColor(109, 170, 224), "Ryu Tor'no", "Literally Kayn from League of Legends", EntityType.ALLY, "Angelic", "Soldier", "Hope Shield", listOf("Diplomacy", "Shield Mastery", "Blacksmithing", ), listOf("Weak in Cold Environments", "Fear of Heights", "Vulnerable to Dark Magic", "Distrustful of Magic", ), 9, 10, 9, 9, 8, 5, mutableListOf(62, 80, 90)),
        Entity(11, "https://picsum.photos/400", DecomposedColor(87, 159, 247), "U'odh Nunh Cryrion", "Literally Gangplank from League of Legends", EntityType.ALLY, "Normal", "Mage", "Sword", listOf("Artisan Craft", "Cooking", "Healing Light", ), listOf("Stubbornness", "Na�ve Compassion", ), 13, 14, 15, 17, 13, 4, mutableListOf(87, 109, 123)),
        Entity(12, "https://picsum.photos/400", DecomposedColor(134, 4, 74), "Nybeth Obdilord Silglia", "Literally Lulu from League of Legends", EntityType.ENEMY, "Normal", "Monster", "Tainted Mace", listOf("Demonic Endurance", "Arcane Mastery", "Shadowstep", ), listOf("Easily Angered", "Emotional Instability", ), 11, 7, 8, 6, 6, 1, mutableListOf(38, 41, 52)),
        Entity(13, "https://picsum.photos/400", DecomposedColor(208, 216, 132), "Asami Syl", "Literally Corki from League of Legends", EntityType.ALLY, "Heart-Bound", "Captain", "Bow", listOf("Archery", "Earth Affinity", ), listOf("Distrustful of Magic", "Aversion to Violence", "Easily Manipulated by Flattery", ), 13, 9, 15, 12, 10, 4, mutableListOf(16, 58, 71)),
        Entity(14, "https://picsum.photos/400", DecomposedColor(5, 208, 188), "Icarus", "Literally Rengar from League of Legends", EntityType.ULTERIOR_BEING, "Life-Mage", "Cherubim", "Will of the Leviathan", listOf("Devotion", ), listOf("Blasphemy", ), 17, 19, 19, 14, 14, 1, mutableListOf(6, 64, 78)),
        Entity(15, "https://picsum.photos/400", DecomposedColor(129, 186, 27), "Piranha Plant Cardon", "Literally Akali from League of Legends", EntityType.ALLY, "Hopeful", "Captain", "Bow", listOf("Blessing Magic", "Arcane Knowledge", ), listOf("Impulsive Decisions", "Susceptible to Corruption", "Aversion to Violence", ), 11, 11, 14, 16, 13, 4, mutableListOf(107, 110, 144)),
        Entity(16, "https://picsum.photos/400", DecomposedColor(244, 116, 6), "Simon Belmont Mea", "Literally Udyr from League of Legends", EntityType.ENEMY, "Void-Consumed", "Wild Animal", "Mace", listOf("Illusion Craft", "Dimension Walking", "Curse Forging", ), listOf("Blood Dependency", "Unstable Mana Flow", ), 7, 9, 7, 7, 3, 1, mutableListOf(24, 49, 93)),
        Entity(17, "https://picsum.photos/400", DecomposedColor(80, 203, 43), "Baji Blaikho", "Literally Taliyah from League of Legends", EntityType.ALLY, "Enlightened", "Soldier", "Glowing Bow", listOf("Smithing", "Herbalism", "Wind Manipulation", ), listOf("Fear of Silence", "Low Stamina", ), 10, 6, 11, 8, 6, 4, mutableListOf(13, 54, 60)),
        Entity(18, "https://picsum.photos/400", DecomposedColor(0, 68, 58), "Zero Suit Samus Ky'ris", "Literally Morgana from League of Legends", EntityType.ALLY, "Life-Mage", "Prominence", "Light Staff", listOf("Diplomacy", "Stealth", "Agility", ), listOf("Reckless in Combat", "Vulnerable to Dark Magic", ), 18, 21, 25, 23, 18, 1, mutableListOf(3, 30, 112)),
        Entity(19, "https://picsum.photos/400", DecomposedColor(97, 164, 110), "Palutena Reran", "Literally Brand from League of Legends", EntityType.ALLY, "Hopeful", "Soldier", "Immortal Hammer", listOf("Stealth", "Archery", ), listOf("Indecisive in Crisis", "Susceptible to Corruption", "Weak in Cold Environments", ), 6, 7, 9, 10, 6, 2, mutableListOf(69, 101, 126)),
        Entity(20, "https://picsum.photos/400", DecomposedColor(211, 112, 45), "Mikuzume Kemarra", "Literally Master Yi from League of Legends", EntityType.ALLY, "Angelic", "Captain", "Immortal Bow", listOf("Ranged Accuracy", "Literacy and Lore", "Leadership", ), listOf("Easily Distracted", "Distrustful of Magic", "Easily Manipulated by Flattery", ), 13, 12, 14, 15, 9, 1, mutableListOf(26, 121, 133)),
        Entity(21, "https://picsum.photos/400", DecomposedColor(61, 240, 53), "Tedalgrinche Wyrm", "Literally Darius from League of Legends", EntityType.ALLY, "Normal", "Citizen", "Shield", listOf("Earth Affinity", "Blacksmithing", "Inventiveness", ), listOf("Weak in Cold Environments", "Fragile Ego", "Low Stamina", ), 7, 5, 5, 6, 7, 5, mutableListOf(51, 95, 99)),
        Entity(22, "https://picsum.photos/400", DecomposedColor(102, 72, 59), "Samus Vihorn", "Literally Skarner from League of Legends", EntityType.ALLY, "Angelic", "Citizen", "Light Sword", listOf("Swordsmanship", "Healing Touch", ), listOf("Easily Distracted", "Susceptible to Corruption", ), 6, 7, 5, 5, 6, 4, mutableListOf(22, 33, 55)),
        Entity(23, "https://picsum.photos/400", DecomposedColor(130, 59, 248), "Ajax", "Literally Bard from League of Legends", EntityType.ULTERIOR_BEING, "Ambitious", "God", "Spear of the Infinite", listOf("Devotion", ), listOf("Blasphemy", ), 23, 24, 23, 25, 22, 3, mutableListOf(21, 103, 137)),
        Entity(24, "https://picsum.photos/400", DecomposedColor(71, 121, 207), "Semele", "Literally Sona from League of Legends", EntityType.ULTERIOR_BEING, "Mind-Bound", "Cherubim", "Will of the Despair", listOf("Devotion", ), listOf("Blasphemy", ), 18, 16, 15, 15, 19, 5, mutableListOf(2, 65, 66)),
        Entity(25, "https://picsum.photos/400", DecomposedColor(176, 219, 161), "Grynewaht pyr Arvina Badon", "Literally Wukong from League of Legends", EntityType.ALLY, "Hopeful", "Mage", "Radiant Shield", listOf("Leadership", "Ranged Accuracy", "Swordsmanship", "Endurance", "Persuasion", ), listOf("Aversion to Violence", "Weak in Cold Environments", ), 16, 16, 19, 14, 13, 3, mutableListOf(4, 96, 102)),
        Entity(26, "https://picsum.photos/400", DecomposedColor(240, 227, 249), "Boxing Kangaroos Chefury", "Literally Taliyah from League of Legends", EntityType.ENEMY, "Ambitious", "Mutant", "Hell Axe", listOf("Illusion Craft", "Demonic Endurance", "Summoning Lesser Beings", ), listOf("Sensitive to Sunlight", "Fear of Silence", ), 14, 12, 10, 9, 10, 5, mutableListOf(88, 91, 122)),
        Entity(27, "https://picsum.photos/400", DecomposedColor(131, 40, 24), "Antigone", "Literally Malphite from League of Legends", EntityType.ULTERIOR_BEING, "Heart-Bound", "Cherubim", "Call of the Heaven", listOf("Devotion", ), listOf("Blasphemy", ), 16, 13, 15, 18, 20, 1, mutableListOf(11, 72, 75)),
        Entity(28, "https://picsum.photos/400", DecomposedColor(226, 171, 113), "Marth Chefury", "Literally Lee Sin from League of Legends", EntityType.ENEMY, "Demonic", "Wild Animal", "Hell Axe", listOf("Charm and Seduction", "Flame Resistance", ), listOf("Vulnerable to Holy Water", "Inability to Lie", "Overreliance on Magic", "Fragile Against Silver", ), 6, 9, 6, 7, 7, 3, mutableListOf(25, 47, 59)),
        Entity(29, "https://picsum.photos/400", DecomposedColor(115, 206, 241), "Helen", "Literally Neeko from League of Legends", EntityType.ULTERIOR_BEING, "Life-Mage", "Angel", "Call of the Big-One", listOf("Devotion", ), listOf("Blasphemy", ), 8, 4, 9, 11, 9, 5, mutableListOf(98, 129, 148)),
        Entity(30, "https://picsum.photos/400", DecomposedColor(188, 73, 132), "Toon Link Ryse", "Literally Soraka from League of Legends", EntityType.ENEMY, "Demonic", "Archdemon", "Condemned Cannon", listOf("Blood Magic", "Fear Induction", ), listOf("Inability to Lie", "Fear of Purity", "Overwhelming Pride", ), 18, 22, 19, 19, 18, 5, mutableListOf(23, 82, 85)),
        Entity(31, "https://picsum.photos/400", DecomposedColor(64, 167, 190), "Antigone", "Literally Lucian from League of Legends", EntityType.ULTERIOR_BEING, "Demonic", "Virtue", "Shock of the Leviathan", listOf("Devotion", ), listOf("Blasphemy", ), 11, 12, 10, 13, 9, 1, mutableListOf(39, 67, 100)),
        Entity(32, "https://picsum.photos/400", DecomposedColor(144, 78, 45), "Akamaru Ce", "Literally Gnar from League of Legends", EntityType.ENEMY, "Blighting", "Mutant", "Cannon", listOf("Arcane Mastery", "Dark Pact Binding", "Energy Absorption", ), listOf("Fear of Purity", "Dependent on Host Form", ), 11, 12, 10, 9, 10, 2, mutableListOf(46, 141, 146)),
        Entity(33, "https://picsum.photos/400", DecomposedColor(200, 1, 110), "Cloud Reran", "Literally Annie from League of Legends", EntityType.ALLY, "Righteous", "Prominence", "Light Bow", listOf("Ranged Accuracy", "Diplomacy", "Swordsmanship", "Arcane Knowledge", ), listOf("Weak in Cold Environments", "Stubbornness", ), 21, 21, 25, 24, 22, 2, mutableListOf(10, 29, 36)),
        Entity(34, "https://picsum.photos/400", DecomposedColor(246, 37, 163), "Caeneus", "Literally Kennen from League of Legends", EntityType.ULTERIOR_BEING, "Death-Mage", "Virtue", "Spear of the Big-One", listOf("Devotion", ), listOf("Blasphemy", ), 9, 7, 15, 11, 14, 2, mutableListOf(31, 48, 89)),
        Entity(35, "https://picsum.photos/400", DecomposedColor(165, 97, 232), "Ariadne", "Literally Gnar from League of Legends", EntityType.ULTERIOR_BEING, "Demonic", "Seraphim", "Call of the Despair", listOf("Devotion", ), listOf("Blasphemy", ), 18, 20, 21, 23, 19, 2, mutableListOf(76, 105, 119)),
        Entity(36, "https://picsum.photos/400", DecomposedColor(44, 116, 158), "Omega Smaugrald", "Literally Lee Sin from League of Legends", EntityType.ENEMY, "Blighting", "Archdemon", "Magma Cannon", listOf("Energy Absorption", "Flame Resistance", "Fear Induction", ), listOf("Vulnerable to Light Magic", "Fragile Against Silver", "Susceptible to Sound-based Attacks", ), 22, 20, 19, 16, 15, 3, mutableListOf(18, 73, 106)),
        Entity(37, "https://picsum.photos/400", DecomposedColor(166, 185, 4), "Charizard Lorlant", "Literally Amumu from League of Legends", EntityType.ENEMY, "Chaotic", "Cataclysm", "Tainted Knuckles", listOf("Arcane Mastery", "Possession", ), listOf("Emotional Instability", "Obsessive Behavior", ), 24, 24, 22, 22, 18, 2, mutableListOf(53, 131, 142)),
        Entity(38, "https://picsum.photos/400", DecomposedColor(108, 180, 86), "Ridley Wingnian", "Literally Jax from League of Legends", EntityType.ALLY, "Enlightened", "Elite", "Sword", listOf("Earth Affinity", "Agility", ), listOf("Poor Night Vision", "Weak in Cold Environments", ), 19, 19, 22, 19, 17, 2, mutableListOf(74, 143, 147)),
        Entity(39, "https://picsum.photos/400", DecomposedColor(67, 141, 233), "Akane Duskaz", "Literally Aurelion Sol from League of Legends", EntityType.ENEMY, "Void-Consumed", "Archdemon", "Tainted Cannon", listOf("Fire Manipulation", "Shadow Weaving", ), listOf("Cannot Cross Running Water", "Fragile Against Silver", ), 18, 20, 19, 16, 19, 2, mutableListOf(56, 114, 120)),
        Entity(40, "https://picsum.photos/400", DecomposedColor(234, 168, 32), "Meta Knight Duskaz", "Literally Annie from League of Legends", EntityType.ENEMY, "Mind-Bound", "Demon", "Cursed Cannon", listOf("Summoning Lesser Beings", "Curse Forging", ), listOf("Lack of Empathy", "Fear of Betrayal", ), 16, 17, 15, 15, 14, 2, mutableListOf(5, 116, 139)),
        Entity(41, "https://picsum.photos/400", DecomposedColor(82, 4, 250), "Mii Sword Fighter Ve-au", "Literally Elise from League of Legends", EntityType.ENEMY, "Death-Mage", "Monster", "Hell Axe", listOf("Energy Absorption", "Shape Shifting", ), listOf("Lack of Empathy", "Fear of Silence", "Blood Dependency", ), 9, 9, 10, 9, 10, 2, mutableListOf(50, 86, 94)),
        Entity(42, "https://picsum.photos/400", DecomposedColor(15, 124, 172), "Phoenix, Mythical Bird of Rebirth Kalius", "Literally Talon from League of Legends", EntityType.ALLY, "Normal", "Mage", "Blessed Hammer", listOf("Agility", "Smithing", ), listOf("Low Stamina", "Impulsive Decisions", ), 16, 13, 14, 19, 14, 2, mutableListOf(134, 151, 152)),
        Entity(43, "https://picsum.photos/400", DecomposedColor(27, 216, 117), "Enzo Tenr? Smaugrald", "Literally Darius from League of Legends", EntityType.ENEMY, "Ambitious", "Monster", "Shattering Cannon", listOf("Shadowstep", "Dark Pact Binding", "Energy Absorption", "Night Vision", ), listOf("Cannot Cross Running Water", "Bound to Specific Territory", ), 8, 9, 9, 9, 9, 3, mutableListOf(42, 117, 118)),
        Entity(44, "https://picsum.photos/400", DecomposedColor(217, 213, 57), "Dr. Mario Lorlant", "Literally Blitzcrank from League of Legends", EntityType.ENEMY, "Normal", "Mutant", "Shattering Whip", listOf("Corruption Spreading", "Summoning Lesser Beings", ), listOf("Fear of Silence", "Susceptible to Sound-based Attacks", ), 12, 11, 10, 10, 11, 2, mutableListOf(32, 128, 138)),
        Entity(45, "https://picsum.photos/400", DecomposedColor(35, 150, 223), "Doragu Burnn", "Literally Thresh from League of Legends", EntityType.ENEMY, "Death-Mage", "Cataclysm", "Condemned Knuckles", listOf("Blood Magic", "Regeneration", "Shadow Weaving", "Fear Induction", ), listOf("Fear of Betrayal", "Fragile Ego", "Fear of Purity", "Unstable Mana Flow", ), 21, 22, 20, 22, 21, 3, mutableListOf(8, 57, 79)),
        Entity(46, "https://picsum.photos/400", DecomposedColor(170, 169, 245), "Peach Rath", "Literally Graves from League of Legends", EntityType.ALLY, "Normal", "Captain", "Sword", listOf("Stealth", "Swordsmanship", "Strategy and Tactics", ), listOf("Tendency to Hesitate", "Bound by Oaths", "Fear of Silence", ), 10, 13, 15, 11, 10, 3, mutableListOf(12, 35, 37)),
        Entity(47, "https://picsum.photos/400", DecomposedColor(19, 221, 167), "Mega Man Silglia", "Literally Katarina from League of Legends", EntityType.ENEMY, "Normal", "Wild Animal", "Magma Cannon", listOf("Fear Induction", "Shadow Weaving", ), listOf("Inability to Lie", "Vulnerable to Holy Water", ), 8, 7, 4, 3, 6, 3, mutableListOf(20, 127, 132)),
        Entity(48, "https://picsum.photos/400", DecomposedColor(128, 162, 87), "Ehll Tou Guekord", "Literally Camille from League of Legends", EntityType.ALLY, "Angelic", "Soldier", "Light Hammer", listOf("Blessing Magic", "Persuasion", "Literacy and Lore", ), listOf("Easily Manipulated by Flattery", "Fear of Silence", "Reckless in Combat", ), 6, 8, 10, 11, 6, 3, mutableListOf(125, 135, 150)),
        Entity(49, "https://picsum.photos/400", DecomposedColor(2, 252, 16), "Tolas Wyrm", "Literally Sion from League of Legends", EntityType.ALLY, "Angelic", "Citizen", "Hope Claws", listOf("Endurance", "Blessing Magic", ), listOf("Easily Fatigued", "Poor Balance", "Fear of Darkness", ), 3, 7, 9, 6, 3, 2, mutableListOf(92, 113, 149)),
        Entity(50, "https://picsum.photos/400", DecomposedColor(119, 169, 218), "Ch?han Vesa", "Literally Gangplank from League of Legends", EntityType.ALLY, "Righteous", "Mage", "Helping Hammer", listOf("Agility", "Persuasion", ), listOf("Bound by Oaths", "Stubbornness", ), 14, 16, 14, 18, 13, 2, mutableListOf(27, 28, 61)),
        Entity(51, "https://picsum.photos/400", DecomposedColor(216, 85, 250), "Thal Thusdeath", "Literally Ziggs from League of Legends", EntityType.ENEMY, "Chaotic", "Cataclysm", "Magma Book", listOf("Corruption Spreading", "Fear Induction", ), listOf("Fear of Purity", "Fear of Silence", "Overwhelming Pride", "Vulnerable to Holy Water", ), 21, 20, 22, 18, 20, 2, mutableListOf(19, 40, 153)),
    )

    private val Surnames = listOf(
        Pair("Vesa", "Fury"),
        Pair("Reran", "Recle"),
        Pair("Vihorn", "Burnn"),
        Pair("Syl", "Ce"),
        Pair("Kemarra", "Chefury"),
        Pair("Guekord", "Thusdeath"),
        Pair("Rath", "Ryse"),
        Pair("Liusneer", "Dagly"),
        Pair("Badon", "Mea"),
        Pair("Tor'no", "Lorlant"),
        Pair("Cryrion", "Smaugrald"),
        Pair("Resnous", "Silglia"),
        Pair("Cardon", "Redta"),
        Pair("Blaikho", "Ve-au"),
        Pair("Wyrm", "Duskaz"),
        Pair("Wingnian", "Smaltspu"),
        Pair("Ry-ma", "Lensa"),
        Pair("Ky'ris", "Diefaneme"),
        Pair("Kalius", "Bluear"),
        Pair("Tresszius", "Jaelec")
    )
    private val Variants = listOf(
        Pair("Virtuous", "Ambitious"),
        Pair("Healing", "Blighting"),
        Pair("Life-Mage", "Death-Mage"),
        Pair("Angelic", "Demonic"),
        Pair("Heart-Bound", "Mind-Bound"),
        Pair("Righteous", "Chaotic"),
        Pair("Hopeful", "Raging"),
        Pair("Enlightened", "Void-Consumed")
    )
    private val PowerLevel = listOf(
        Triple("Citizen", "Wild Animal", "Angel"),
        Triple("Soldier", "Monster", "Virtue"),
        Triple("Captain", "Mutant", "Throne"),
        Triple("Mage", "Demon", "Cherubim"),
        Triple("Elite", "Archdemon", "Seraphim"),
        Triple("Prominence", "Cataclysm", "God")
    )
    private val Weapon = listOf(
        Triple("Sword", "Knuckles", "Spear"),
        Triple("Staff", "Book", "Memory"),
        Triple("Bow", "Cannon", "Will"),
        Triple("Shield", "Mace", "Call"),
        Triple("Hammer", "Axe", "Fate"),
        Triple("Claws", "Whip", "Shock")
    )
    private val WeaponAttribute = listOf(
        Triple("Light", "Hell", "Heaven"),
        Triple("Hope", "Magma", "Despair"),
        Triple("Radiant", "Tainted", "Leviathan"),
        Triple("Glowing", "Shattering", "Big-One"),
        Triple("Blessed", "Cursed", "Forgotten"),
        Triple("Helping", "Crushing", "Abyss"),
        Triple("Immortal", "Condemned", "Infinite")
    )
    private val Talents = listOf(
        Pair("Swordsmanship", "Fire Manipulation"),
        Pair("Archery", "Shadow Weaving"),
        Pair("Healing Light", "Blood Magic"),
        Pair("Smithing", "Soul Drain"),
        Pair("Elemental Control (Fire)", "Illusion Craft"),
        Pair("Strategy and Tactics", "Dark Pact Binding"),
        Pair("Herbalism", "Fear Induction"),
        Pair("Persuasion", "Corruption Spreading"),
        Pair("Leadership", "Regeneration"),
        Pair("Cooking", "Curse Forging"),
        Pair("Arcane Knowledge", "Arcane Mastery"),
        Pair("Stealth", "Telepathy"),
        Pair("Quick Reflexes", "Lightning Affinity"),
        Pair("Endurance", "Earthshaping"),
        Pair("Earth Affinity", "Astral Projection"),
        Pair("Blessing Magic", "Dimension Walking"),
        Pair("Ranged Accuracy", "Energy Absorption"),
        Pair("Shield Mastery", "Venom Secretion"),
        Pair("Literacy and Lore", "Charm and Seduction"),
        Pair("Light Affinity", "Demonic Endurance"),
        Pair("Diplomacy", "Bonecrafting"),
        Pair("Inventiveness", "Flame Resistance"),
        Pair("Wind Manipulation", "Ritual Casting"),
        Pair("Blacksmithing", "Shadowstep"),
        Pair("Agility", "Night Vision"),
        Pair("Artisan Craft", "Summoning Lesser Beings"),
        Pair("Healing Touch", "Possession"),
        Pair("Musical Talent", "Mana Overload"),
        Pair("Virtue and Morale", "Shape Shifting"),
        Pair("Tactical Foresight", "Infernal Tongue")
    )
    private val Weaknesses = listOf(
        Pair("Poor Night Vision", "Aversion to Holy Symbols"),
        Pair("Fear of Darkness", "Vulnerable to Light Magic"),
        Pair("Overconfidence", "Bound by Ancient Runes"),
        Pair("Prideful Nature", "Easily Angered"),
        Pair("Weak Against Poison", "Fragile Against Silver"),
        Pair("Reckless in Combat", "Overwhelming Pride"),
        Pair("Poor Orientation", "Inability to Lie"),
        Pair("Low Stamina", "Blood Dependency"),
        Pair("Fear of Heights", "Weak Against Cold"),
        Pair("Easily Distracted", "Obsessive Behavior"),
        Pair("Susceptible to Corruption", "Cannot Cross Running Water"),
        Pair("Emotional Attachment", "Overconfident in Power"),
        Pair("Vulnerable to Dark Magic", "Susceptible to Sound-based Attacks"),
        Pair("Claustrophobia", "Fragile Ego"),
        Pair("Stubbornness", "Dependent on Host Form"),
        Pair("Impulsive Decisions", "Vulnerable to Divine Oaths"),
        Pair("Fragile Ego", "Fear of Betrayal"),
        Pair("Easily Manipulated by Flattery", "Easily Corrupted by Own Magic"),
        Pair("Distrustful of Magic", "Sensitive to Sunlight"),
        Pair("Weak in Cold Environments", "Unstable Mana Flow"),
        Pair("Fear of Silence", "Weak Against Runes of Binding"),
        Pair("Bound by Oaths", "Fear of Silence"),
        Pair("Naïve Compassion", "Easily Provoked"),
        Pair("Tendency to Hesitate", "Bound to Specific Territory"),
        Pair("Limited Magical Control", "Weak Against Silver Weapons"),
        Pair("Easily Fatigued", "Emotional Instability"),
        Pair("Fear of Blood", "Vulnerable to Holy Water"),
        Pair("Poor Balance", "Lack of Empathy"),
        Pair("Indecisive in Crisis", "Overreliance on Magic"),
        Pair("Aversion to Violence", "Fear of Purity")
    )

//    fun calculateStat(entityTier: Int, tierMultiplier: Int = 3, isBoosted: Boolean = false, boostCap: Int = 3): Int {
//        var result: Int = 0;
//
//        result += Random.nextInt(3 + 3 * entityTier, 8 + 3 * entityTier);
//
//        if(isBoosted)
//            result += Random.nextInt(1, boostCap + 1);
//
//        return result;
//    }
//
//    fun generateEntity(): Entity {
//        val zoneDaoImpl = factoryDaoZones.createDao(Origin.MEMORY);
//        val dataZone: List<Zone>;
//        val entityDaoImpl = factoryDaoEntities.createDao(Origin.MEMORY);
//        val dataEntity: List<Entity>;
//        val faker : Faker = Faker();
//        val id: Int = this.id;
//        val name: String;
//        val description : String;
//        var entityType : EntityType;
//        val variant: String;
//        val powerLevel: String;
//        val weapon: String;
//        val talents: MutableList<String> = mutableListOf();
//        val weaknesses: MutableList<String> = mutableListOf();
//        val life: Int;
//        val attack: Int;
//        val defense: Int;
//        val speed: Int;
//        val magic: Int;
//        val currentZoneLocation: Int;
//        var chanceBasedNumber: Int;
//        val posSurname: Int;
//        val posVariant: Int;
//        val posPowerLevel : Int;
//        val posWeapon: Int;
//        val posWeaponAttribute: Int;
//        var stillAvailableTalents: List<Pair<String, String>>;
//        var stillAvailableWeaknesses: List<Pair<String, String>>;
//        var count: Int = 0;
//
//        dataZone = zoneDaoImpl.obtenTots();
//        dataEntity = entityDaoImpl.obtenTots();
//
//        description = "Literally " + faker.leagueOfLegends().champion() + " from League of Legends";
//
//        posPowerLevel = Random.nextInt(0, PowerLevel.size);
//        posWeapon = Random.nextInt(0, Weapon.size);
//
//        chanceBasedNumber = faker.number().numberBetween(0, 10);
//
//        do{
//            if (chanceBasedNumber < 4)
//                entityType = EntityType.ALLY;
//            else if (chanceBasedNumber < 8)
//                entityType = EntityType.ENEMY;
//            else
//                entityType = EntityType.ULTERIOR_BEING;
//        }while(faker.number().numberBetween(0, 10) < 9 && entityType == EntityType.ULTERIOR_BEING);
//
//        when(entityType)
//        {
//            EntityType.ALLY -> {
//                posSurname = Random.nextInt(0, Surnames.size);
//
//                name = when(faker.number().numberBetween(0, 3))
//                {
//                    0 -> faker.finalFantasyXIV().character();
//                    1 -> faker.superSmashBros().fighter();
//                    2 -> faker.naruto().character();
//                    else -> throw IllegalArgumentException("The argument gotten for the when statement wasn't considered possible");
//                } + " " + Surnames[posSurname].first;
//
//                if(faker.number().numberBetween(0, 10) < 8)
//                {
//                    posVariant = Random.nextInt(0, Variants.size);
//                    variant = Variants[posVariant].first;
//                }
//                else
//                    variant = "Normal";
//
//                powerLevel = PowerLevel[posPowerLevel].first;
//
//                if(Random.nextInt(0, 10) < 7)
//                {
//                    posWeaponAttribute = Random.nextInt(0, WeaponAttribute.size);
//                    weapon = WeaponAttribute[posWeaponAttribute].first + " " + Weapon[posWeapon].first;
//                }
//                else
//                    weapon = Weapon[posWeapon].first;
//
//                life = calculateStat(posPowerLevel);
//                attack = calculateStat(posPowerLevel);
//                defense = calculateStat(posPowerLevel, isBoosted = true);
//                speed = calculateStat(posPowerLevel, isBoosted = true);
//                magic = calculateStat(posPowerLevel);
//
//                do{
//                    stillAvailableTalents = Talents.filter{ !talents.contains(it.first) };
//                    talents.add(stillAvailableTalents.get(faker.number().numberBetween(0, stillAvailableTalents.size)).first);
//                    count++;
//                }while(faker.number().numberBetween(0.0, Math.pow(2.0, count.toDouble())) < 2 && count < Talents.size)
//
//                count = 0;
//                do{
//                    stillAvailableWeaknesses = Weaknesses.filter{ !weaknesses.contains(it.first) };
//                    weaknesses.add(stillAvailableWeaknesses.get(faker.number().numberBetween(0, stillAvailableWeaknesses.size)).first);
//                    count++;
//                }while(faker.number().numberBetween(0.0, Math.pow(2.0, count.toDouble())) < 2 && count < Weaknesses.size)
//            }
//            EntityType.ENEMY -> {
//                posSurname = Random.nextInt(0, Surnames.size);
//
//                name = when(faker.number().numberBetween(0, 3))
//                {
//                    0 -> faker.finalFantasyXIV().character();
//                    1 -> faker.superSmashBros().fighter();
//                    2 -> faker.naruto().character();
//                    else -> throw IllegalArgumentException("The argument gotten for the when statement wasn't considered possible");
//                } + " " + Surnames[posSurname].second;
//
//                if(Random.nextInt(0, 10) < 8)
//                {
//                    posVariant = Random.nextInt(0, Variants.size);
//                    variant = Variants[posVariant].second;
//                }
//                else
//                    variant = "Normal";
//
//                powerLevel = PowerLevel[posPowerLevel].second;
//
//                if(Random.nextInt(0, 10) < 7)
//                {
//                    posWeaponAttribute = Random.nextInt(0, WeaponAttribute.size);
//                    weapon = WeaponAttribute[posWeaponAttribute].second + " " + Weapon[posWeapon].second;
//                }
//                else
//                    weapon = Weapon[posWeapon].second;
//
//                life = calculateStat(posPowerLevel, isBoosted = true);
//                attack = calculateStat(posPowerLevel, isBoosted = true);
//                defense = calculateStat(posPowerLevel);
//                speed = calculateStat(posPowerLevel);
//                magic = calculateStat(posPowerLevel);
//
//                do{
//                    stillAvailableTalents = Talents.filter{ !talents.contains(it.second) };
//                    talents.add(stillAvailableTalents.get(faker.number().numberBetween(0, stillAvailableTalents.size)).second);
//                    count++;
//                }while(faker.number().numberBetween(0.0, Math.pow(2.0, count.toDouble())) < 2 && count < Talents.size)
//
//                count = 0;
//                do{
//                    stillAvailableWeaknesses = Weaknesses.filter{ !weaknesses.contains(it.second) };
//                    weaknesses.add(stillAvailableWeaknesses.get(faker.number().numberBetween(0, stillAvailableWeaknesses.size)).second);
//                    count++;
//                }while(faker.number().numberBetween(0.0, Math.pow(2.0, count.toDouble())) < 2 && count < Weaknesses.size)
//            }
//            EntityType.ULTERIOR_BEING -> {
//                name = faker.ancient().hero();
//
//                posVariant = Random.nextInt(0, Variants.size);
//                if(Random.nextInt(0, 2) == 1)
//                    variant = Variants[posVariant].first;
//                else
//                    variant = Variants[posVariant].second;
//
//                powerLevel = PowerLevel[posPowerLevel].third;
//
//                posWeaponAttribute = Random.nextInt(0, WeaponAttribute.size);
//
//                weapon = Weapon[posWeapon].third + " of the " + WeaponAttribute[posWeaponAttribute].third;
//
//                life = calculateStat(posPowerLevel, 5,true, 5);
//                attack = calculateStat(posPowerLevel, 5,true, 5);
//                defense = calculateStat(posPowerLevel, 5,true, 5);
//                speed = calculateStat(posPowerLevel, 5,true, 5);
//                magic = calculateStat(posPowerLevel, 5,true, 5);
//
//                talents.add("Devotion");
//                weaknesses.add("Blasphemy");
//            }
//            else -> throw Exception("Impossible parameter detected");
//        }
//
//        if(dataZone.filter { n -> dataEntity.count{ m -> m.currentZoneLocation == n.id } < n.maxEntities }.isNotEmpty())
//            currentZoneLocation = dataZone.filter { n -> dataEntity.count{ m -> m.currentZoneLocation == n.id } < n.maxEntities }.random().id;
//        else
//            throw Exception("There are no zones unoccupied right now")
//
//        this.id++;
//
//        return Entity(
//            id,
//            "https://picsum.photos/400",
//            DecomposedColor(),
//            name,
//            description,
//            entityType,
//            variant,
//            powerLevel,
//            weapon,
//            talents,
//            weaknesses,
//            life,
//            attack,
//            defense,
//            speed,
//            magic,
//            currentZoneLocation,
//            mutableListOf()
//        )
//    }

    override fun insereix(entity: Entity): Boolean {
        var result: Boolean = true;
        val zoneDaoImpl = factoryDaoZones.createDao(Origin.MEMORY);
        val dataZone: List<Zone>;
        val indexParentZone: Int;
        val parentZone: Zone;

        dataZone = zoneDaoImpl.obtenTots();
        indexParentZone = dataZone.indexOfFirst{ n -> n.id == entity.currentZoneLocation };
        if(dades.any{it.id == entity.id})
            result = false;
        else
        {
            if(indexParentZone >= 0)
            {
                parentZone = zoneDaoImpl.obtenPerID(entity.currentZoneLocation)!!;
                if(dades.count{ n -> n.currentZoneLocation == entity.currentZoneLocation } <
                    dataZone.find{ n -> n.id == entity.currentZoneLocation }!!.maxEntities)
                {
                    dades.add(entity);
                    parentZone.entities.add(entity.id);
                }
                else
                    result = false;
            }
            else
                result = false;
        }

        return result;
    }

    override fun actualitza(entity: Entity): Boolean {
        val position = dades.indexOfFirst { it.id == entity.id }
        var result: Boolean = true;
        val zoneDaoImpl = factoryDaoZones.createDao(Origin.MEMORY);
        val dataZone: List<Zone>;
        val indexParentZone: Int;

        dataZone = zoneDaoImpl.obtenTots();
        indexParentZone = dataZone.indexOfFirst{ n -> n.id == entity.currentZoneLocation };
        if(position < 0)
            result = false;
        else
        {
            if(indexParentZone >= 0)
            {
                if(dades.count{ n -> n.currentZoneLocation == entity.currentZoneLocation } <
                    dataZone.find{ n -> n.id == entity.currentZoneLocation }!!.maxEntities ||
                    entity.currentZoneLocation == dades[position].currentZoneLocation)
                {
                    dades[position] = entity;
                }
                else
                    result = false;
            }
            else
                result = false;
        }

        return result;
    }

    override fun elimina(id: Int): Boolean {
        var result: Boolean = true;
        val position = dades.indexOfFirst { it.id == id }
        val missionDaoImpl = factoryDaoMissions.createDao(Origin.MEMORY);
        val dataMission: List<Mission>;

        dataMission = missionDaoImpl.obtenTots();
        if(position < 0)
            result = false;
        else
        {
            dades.removeAt(position);
            dataMission.filter{ n -> n.acceptedBy == id }.forEach {
                missionDaoImpl.elimina(it.id);
            }
        }

        return result;
    }

    override fun obtenPerID(id: Int): Entity? {
        return dades.firstOrNull{id == it.id}
    }

    override fun obtenTots(): List<Entity> {
        return dades.toList();
    }
}