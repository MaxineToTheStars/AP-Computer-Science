// Package Declaration
package app.classes;

// Import Statements

// File Docstring
/**
 * MazeGamev2 || Story.java
 * <p>
 * Data representation of a {@link Story}
 * 
 * @author https://github.com/MaxineToTheStars
 */

// Class Definition
public class Story {
	// Enums

	// Interfaces

	// Constants
	private static String[] BACKSTORY_TEXT_TEMPLATE = {
			"A Daring Adventurer:\n[%PLAYER_NAME%] was exploring ancient ruins when the ground crumbled beneath their feet.\nPlunging into darkness, [%PLAYER_NAME%] landed hard in a dank dungeon, the only sound their ragged breath.\nWith nothing but a flickering torch and a thirst for survival, [%PLAYER_NAME%] must navigate the treacherous depths, facing whatever perils lie in wait.\n",
			"A Notorious Treasure Hunter:\n[%PLAYER_NAME%] had spent years chasing rumors of a hidden vault within the abandoned Elven city of Elarae.\nFinally, after weeks of scouring ancient texts and deciphering cryptic clues, [%PLAYER_NAME%] found it – a hidden entrance concealed behind an overgrown tapestry.\nArmed with their trusty blade and a keen eye, [%PLAYER_NAME%] ventured into the darkness, the air thick with the scent of dust and decay.\n",
			"The Call Of Adventure:\n[%PLAYER_NAME%] was raised in a hidden village nestled amongst the ancient trees. [%PLAYER_NAME%]'s people, skilled in the arts of stealth and survival, lived in harmony with the forest, their lives a well-kept secret from the outside world.\nHowever, [%PLAYER_NAME%] yearned for adventure, drawn by the whispers of the wind and the stories carried on its wings.\nOne day, unable to resist the call any longer, [%PLAYER_NAME%] left the familiar embrace of the woods, setting foot on the unknown path that lay ahead.\n",
			"The Seeker Of Lost Lore:\nThe whispers of the forgotten pulled [%PLAYER_NAME%] in, a siren song of secrets and lost knowledge.\nBeneath a crimson moon, [%PLAYER_NAME%]'s restless spirit yearned for adventure, for something beyond the familiar fields and quiet village life.\nTales of ancient heroes and forgotten kingdoms filled their dreams, fueling a curiosity that burned brighter than any hearth fire.\n",
			"A Tapestry of Scars:\nScarred by countless adventures, [%PLAYER_NAME%]'s eyes held a youthful curiosity for the unknown.\nLegends whispered of their exploits, but their true motive resided in a dusty library, fueled by ancient tales and forgotten maps.\nNow, standing before a legendary cave, they stepped into the darkness, ready to write their own chapter in the tapestry of time.\n",
	};

	private static String[] NEUTRAL_IDLE_TEXT = {
			"The musty air hangs heavy, thick with the weight of ages.\nA gentle breeze whispers through the cave, carrying the faint scent of moss and decaying leaves.\nWater drips rhythmically from unseen stalactites, punctuating the silence with a soft, persistent plink-plonk.\n",
			"The ground beneath your feet is uneven, littered with the bones of unfortunate creatures who dared to venture into this forsaken place.\nThe air grows colder with each step, and a strange, spectral mist begins to swirl around your ankles, obscuring the path ahead.\nThe oppressive silence is suddenly shattered by a bloodcurdling scream that echoes through the cavern, sending shivers down your spine.\n",
			"A cold wind whispers through the cave, carrying the scent of ancient stone and stagnant water.\nDarkness hangs heavy, pierced only by the faint glow of distant crystals.\nShadows dance on the damp walls, taking on monstrous shapes that shift and writhe.\nEach drip of water echoes through the cavern, a macabre heartbeat in the oppressive silence. You feel watched, unseen eyes judging your every move.\n",
			"The cool, damp air brushes your skin.\nThe heavy scent of earth and stone mingles with the faint sweetness of moss and damp ferns.\nA steady symphony of dripping water echoes through the vast chamber, each drop adding to the rhythmic chorus that whispers of ancient secrets.\n",
			"A gust of wind whips through the cavern, momentarily extinguishing your torch and plunging you into complete darkness.\nYour heart races as the silence thickens, the only sound your own ragged breaths and the amplified echo of your heartbeat.\nA moment later, the wind dies down, and you fumble for your torch, its flickering flame once again revealing the mysterious depths of the cave.\n",
			"The cavern's embrace is a mix of serenity and mystery, a place where time seems to stand still and the secrets of the earth whisper tales of forgotten ages.\nAs you explore its dark depths, you are not just a visitor, but a part of the cave's ancient story, forever bound to its timeless beauty and captivating wonder.\n",
			"The air shimmers with a cool, ethereal glow as you step into the crystal filled cavern.\nThe cavern walls are adorned with countless glittering crystals, each refracting the faint light of your torch into a kaleidoscope of colors.\nStalactites and stalagmites resemble frozen waterfalls, their shimmering surfaces casting long, dancing shadows on the crystal-studded floor.\n",
			"The chill air whispers through the cavern, carrying the faint scent of damp earth and decaying leaves, mingling with the metallic tang of unseen minerals, a haunting melody that speaks of ages past.\n",
			"The rhythmic drip of water echoes through the vast cavern, punctuated only by the occasional chirp of a distant bat and the muffled sigh of the wind through unseen cracks in the ancient stone,\nweaving a mesmerizing melody that lulls you deeper into the heart of the earth, where the darkness holds secrets whispered by time itself,\nsecrets waiting to be unearthed by the light of your torch and the courage of your heart.\n",
			"The cave swallowed the light, leaving only the rhythmic drip of water.\nSilhouettes of stalactites loomed, casting dancing shadows on the bioluminescence walls.\nA silver flash of an iron beetle startled you, a fleeting glimpse of life in the vast, echoing darkness.\n",
	};

	private static String[] NEUTRAL_MOVEMENT_TEXT = {
			"Your boots crunch softly on the damp earth and gravel, each step a small tremor in the cavernous silence.\nA low drip of water echoes through the chamber, its rhythm punctuated by the occasional sigh of wind that whistles through unseen cracks in the ceiling.\n",
			"The air in the cavern is stagnant, thick with the damp scent of moss and decaying leaves.\nYour boots thud softly on the uneven stone floor, each step echoing with an unsettling finality in the oppressive silence.\nA faint sliver of moonlight filters through a crack in the ceiling, casting a ghostly pale beam that dances across the rough-hewn walls, revealing grotesque shapes carved into the stone by time and erosion.\n",
			"The silence stretched before you, broken only by the rhythmic crunch of your boots on the gravel floor.\nThe echo of each step reverberated through the vast cavern, amplifying the stillness and filling you with a sense of unease.\n",
			"The cold, damp air clung to your skin, a constant reminder of the cave's frigid embrace. Your fingers brushed against the rough stone walls, the texture of the past worn smooth by time and water.\nA sudden rustle in the darkness made you jump, sending shivers down your spine as you imagined unseen creatures scuttling across the floor.\n",
			"Your boots crunched on the damp gravel floor, the sound echoing through the vast, echoing chamber like a death knell.\nThe only other sound was the persistent dripping of water from somewhere above, each drop falling with a chilling finality.\n",
			"Your boots crunch on a layer of dust as you enter the chamber, the silence broken only by the echo of your steps.\nA faint hum vibrates in the air, growing louder as you approach a glowing artifact.\nA strong purple light emits from the strange tablet. The air feels thick and cold, and you swear you hear whispers carried on the wind, indistinguishable but unsettling.\n",
			"The air is deathly still, and the reflections in the crystals distort your image, making you question your own reality.\nYour boots click rhythmically against the polished crystal floor, each step resonating with an eerie chime.\nA low moan echoes through the labyrinth, its source unknown and seemingly following your every move.\n",
			"The air grows heavier and more humid as you descend deeper into the cave. The temperature drops significantly, sending shivers down your spine.\nThe darkness intensifies, forcing you to rely solely on the flickering light of your torch.\nA sense of anticipation builds as you near your destination, the unknown dangers lurking within the cave fueling your curiosity.\n",
			"The crystals refract the light of your torch, creating a dazzling display of colors and patterns on the cavern walls.\nYou feel a sense of awe and wonder as you marvel at the beauty and fragility of the crystal cave, aware of the precariousness of your position above the vast chasm below.\nThe air in the chamber feels stagnant and heavy, filled with the echoes of the past.\n",
			"The air thickens and grows heavy as you step into a vast chamber with no apparent source of light.\nEerie whispers seem to emanate from the walls themselves, their voices echoing in the darkness. You strain your ears to decipher the whispers, unable to determine their origin or meaning.\nA sense of unease settles in your stomach, the whispers fueling your imagination and conjuring unsettling images. You continue your exploration with a newfound caution, driven by both fear and curiosity.\n",
	};

	private static String[] POSITIVE_MOVEMENT_TEXT = {
			"The cave echoes with your footsteps, the air thick and stale.\nA glint of metal catches your eye. Brushing away the dirt, you reveal a magnificent dagger, its jewels shimmering in the dim torchlight.\nAncient inscription speaks of power and danger.\n",
			"Darkness swallows your torchlight. A strange glow draws you deeper.\nPulsating in the center of a forgotten alcove, a crystal hums with unseen energy.\nImages flash before you: lost rituals, forgotten civilizations, and magic's secrets.\n",
			"Darkness swallows your torchlight.\nAncient carvings dance with an ethereal song.\nA gleaming stone harp hums with forgotten knowledge.\n",
			"Darkness devoured your torch, plunging you into despair. But then, a glimmer of hope!\nA hidden chamber, bathed in the ethereal glow of luminous crystals. A crystal pool, life-giving plants, and the calming sound of water.\nSafe and revitalized, you appreciated the unexpected beauty found in the heart of darkness.\n",
			"Trapped in a suffocating passage, your desperate touch found a hidden door. Warm, flower-scented air and a melodic voice beckoned you forward.\nA vast, ethereal cavern awaited, filled with glistening crystals and a wisdom-filled song.\nImages of an ancient civilization and their connection to the earth gifted you with knowledge and renewed purpose.\n",
			"Cave darkness swallowed your light. Earth trembled, revealing a hidden path. Beyond, a luminous cavern bloomed with bioluminescence flora and a shimmering pool.\nFear turned to wonder as you found sanctuary in this secret paradise of light.\n",
			"As you explore deeper into the cave, you find a hidden opening leading to a lush underground oasis.\nA clear pool of water reflects the light, surrounded by vibrant green vegetation and exotic flowers. The air is filled with the sweet fragrance of blooming plants and the chirping of unseen birds.\nYou spend time relaxing in the peaceful oasis, replenishing your energy and enjoying the unexpected beauty.\n",
			"While exploring a seemingly dead end, you discover a hidden passage behind a thick curtain of vines.\nThe passage leads to a previously unknown section of the cave, filled with untouched wonders and unexplored possibilities.\nYou feel a surge of excitement as you enter the passage, eager to discover the secrets it holds.\n",
			"You stumble upon a hidden chamber containing a pulsating crystal that emanates a powerful energy. The energy washes over you, revitalizing your body and mind.\nYou feel a surge of strength and clarity, empowered to face any challenge that may arise on your journey.\n",
			"You discover a hidden chamber adorned with ancient paintings on the walls. The paintings depict scenes of hunting, rituals, and everyday life from a long-forgotten civilization.\nYou spend time studying the artwork, gaining valuable insights into the lives and history of the people who once inhabited the cave.\n",
	};

	private static String[] NEGATIVE_MOVEMENT_TEXT = {
			"The ground gives way, plunging you into darkness. Pain shoots through your leg. Trapped and injured, fear grips you.\nA low growl can be heard distant behind you...You shove away some rocks to free your legs\nYour hands, now bloody, paint the whole cave red.\n",
			"You activate a trap in the cave's depths. Razor-sharp stalactites rain down, piercing your shoulder and leg.\nDarkness swallows you whole, and the only sound is the drip of unseen water. Panic rises, but you bandage your wounds and crawl towards a faint glimmer of light.\n",
			"Your foot catches on a loose rock hidden under a layer of fallen leaves. You lose your balance and tumble down a steep incline, landing hard on the uneven cave floor.\nPain shoots through your ankle, and you realize you have sprained it.\nThe injury hinders your movement and makes it difficult to walk, forcing you to adapt your plans and proceed with caution.\n",
			"Distracted by the mesmerizing patterns on the cave wall, you fail to notice the low-hanging rock formation above.\nYou collide with it headfirst, the impact momentarily disorienting you and leaving a throbbing bruise.\nStars dance in your vision, and a wave of nausea washes over you as you struggle to regain your composure.\n",
			"As you venture through a narrow passage, you disturb a colony of sleeping cave bats.\nStartled awake, they erupt in a frenzy, their leathery wings beating against your face and body. Their sharp claws and teeth tear at your exposed skin, inflicting painful wounds.\nYou fight back, desperately trying to defend yourself from the swarm of enraged creatures.\n",
			"Mistaking a thin layer of dirt for solid ground, you step onto a hidden crevice.\nThe earth gives way beneath your weight, and you plummet into a deep, dark pit.\nPanic sets in as you fall, the air rushing past your ears. You land hard on the rough floor, adrenaline coursing through your veins as you assess your injuries and ponder your next move.\n",
			"You navigate a narrow tunnel, the silence broken only by your own footsteps and the dripping of water.\nSuddenly, a tremor shakes the cave, and the ceiling above you begins to crumble. With a deafening roar, a section of the tunnel collapses behind you, blocking your escape route.\nPanic surges through you as you assess the situation, realizing you are trapped until you can find another way out.\n",
			"You journey through the cave, guided by the flickering light of your torch. Suddenly, a tremor shakes the cave, causing your torch to fall and shatter.\nYou are plunged into complete darkness, disoriented and vulnerable. The silence is broken only by the dripping of water and the echoes of your own heartbeat.\n",
			"As you explore deeper into the cave, you begin to experience chilling visions and ghostly apparitions.\nThe spirits whisper unsettling messages, revealing dark secrets of the cave's past and attempting to lure you into danger.\nYou resist their influence and remain focused on your goal, lest you be consumed by the darkness.\n",
			"You encounter a series of branching paths within the cave. Markings and symbols adorn the walls, promising shortcuts and hidden treasures.\nHowever, these symbols are expertly forged, leading you down dead ends and treacherous paths.\nFrustration grows as you retrace your steps, carefully reassessing the markings and searching for clues to reveal the true path forward.\n",
	};

	private static String[][] AVAILABLE_MOVEMENT_OPTIONS = {
			{ "Rappel down a jagged cliff face", "The abyss below a swirling mystery.\n" },
			{ "Climb the natural steps carved into the cave wall", "With the one true hope of making it out.\n" },
			{ "Explore the cave's network of tunnels", "Guided by the constant rhythm of dripping water.\n" },
			{ "Feel your way through the darkness", "Hands tracing the contours of the rough stone.\n" },
			{ "Squeeze through a small opening",
					"Your body contorts as you inch through a tight passageway, feeling the cold rock scrape against your skin.\n" },
			{ "Cross a precarious ledge",
					"A narrow ledge overlooking a bottomless chasm, battling your fear of heights.\n" },
			{ "Descend into a bottomless pit",
					"A seemingly endless abyss, encountering unique flora and fauna adapted to the eternal darkness.\n" },
			{ "Descend into a volcanic chasm",
					"A crevice leading into a smoldering volcanic chamber, dodging falling lava and navigating treacherous terrain.\n" },
			{ "Traverse a precarious crystal bridge",
					"A narrow bridge made entirely of shimmering crystals, testing your balance and agility to avoid falling into the chasm below.\n" },
			{ "Navigate the hallucinogenic mist",
					"A cavern filled with a shimmering mist that induces vivid hallucinations.\n" },

	};

	private static String[] POSITIVE_STATUS_TEXT = {
			"You are filled with determination.",
			"Even the smallest flame can light up the darkest dungeon.",
			"May your dice roll ever in your favor.",
			"With every sunrise, a new quest begins.",
			"May my heart be as pure as a crystal clear spring.",
			"My inner dragon roars with optimism",
			"Grateful for the melodies sung by the wind spirits.",
			"May my thoughts be as clear as the waters of a sacred spring.",
			"My soul dances to the rhythm of the ancient drums, urging me forward on my quest.",
			"Feeling as brave and bold as a knight venturing into the unknown.",
	};

	private static String[] NEGATIVE_STATUS_TEXT = {
			"The darkness within the dungeon seems to mirror the darkness within.",
			"A pact at the abyss' edge. The price? Your soul.",
			"Sanity hangs by a thread. Can you pull yourself back from the brink?",
			"The shadows offer refuge, but they crave your soul in return.",
			"Feeling as trapped as a creature in a witch's cage.",
			"The shadows lengthen within my soul, threatening to consume me whole.",
			"My heart is a graveyard of shattered dreams and poisoned hopes.",
			"Trapped in a nightmare that stretches into an eternity of suffering.",
			"My mind is a twisted labyrinth, where logic and reason have been lost forever.",
			"The darkness whispers promises of oblivion, and I find myself yearning for its embrace.",
	};

	private static String[] CHOICE_TITLES = {
			"A Fork In The Road",
			"Point Of No Return",
			"Unforeseen Consequences",
			"Stepping Into The Unknown",
			"A Leap Of Faith",
			"The Bridge Between Worlds",
			"The Unknown",
			"Embracing The Unexpected",
			"Diverging Paths",
			"Take The Plunge"
	};

	private static String[] ACTION_TITLES = {
			"The Path Is Chosen",
			"There's No Turning Back Now",
			"Fate has spoken",
			"The Unknown Awaits",
			"The Stage Is Set",
			"The Wind Whispers Of The Chosen Path",
			"The River Of Time Flows Ever Onward, Towards The Chosen Destination",
			"Destiny's Loom Has Woven Its Tapestry",
			"The Adventure Unfolds",
			"The Hand Of Fate",
	};

	private static String[] WIN_MESSAGES = {
			"You emerged from the cave not only with your life, but also with a wealth of knowledge and experience.\nThe darkness served as your crucible, forging you into a stronger, wiser version of yourself.\nCarry this wisdom with you into the light, and let it guide you on your path.\n",
			"With a triumphant sigh, you step out of the labyrinth, the echoes of your triumphant journey still reverberating through the intricate passageways.\nThe treacherous path you traversed has forever etched itself into your memory, a testament to your courage, perseverance, and unwavering determination.\nYour victory serves as a beacon of hope for future explorers who may dare to venture into the labyrinth's depths, knowing that they can overcome any obstacle with the right mindset and spirit.\n",
			"You emerge from the collapsing cave just as the entrance seals shut, the monstrous entity trapped within its earthen tomb.\nThe ground still trembles beneath your feet, the memory of the horrifying visions etched deeply into your mind.\nYet, amidst the fear and adrenaline, you feel a surge of pride and relief. You have survived the unimaginable, faced the wrath of an ancient evil, and emerged victorious.\nThe knowledge of your triumph fills you with newfound strength and determination, knowing that you are capable of overcoming any obstacle that may come your way.\nYour ordeal has marked you forever, but it has also shaped you into a hero, forever bound to the echoes of the cave and the secrets it holds.\n",
	};

	private static String[] DEATH_MESSAGES = {
			"The darkness comes alive as a monstrous creature emerges from the shadows.\nIts razor-sharp claws tear through your defenses, and its guttural roar fills your ears moments before it swallows you whole.\nYour screams are lost in the depths of the cave, a chilling reminder of the dangers that lurk within.\n",
			"A monstrous spider, its body larger than a man, emerges from the shadows. Its silken webs entangle you, immobilizing you as the creature approaches with venomous fangs bared.\nYou struggle against the sticky strands, but your efforts are in vain. The spider delivers a fatal bite, its venom coursing through your veins as you succumb to its deadly embrace.\n",
			"As you wander through the maze of tunnels, you stumble upon a colossal troll guarding a hidden treasure.\nThe troll, enraged by your intrusion, attacks with brutal ferocity. Its immense strength crushes your bones, and its roar echoes through the cavern as it feasts upon your remains.\n",
			"A colossal wyrm bursts from the depths of the cave, its body adorned with scales that shimmer with an otherworldly glow.\nIts massive jaws clamp down on your leg, its sharp teeth tearing through flesh and bone. You scream in agony as the wyrm throws you against the cave wall, your body pierced by its venomous spines.\n",
			"Unknowingly, you step upon a hidden pressure plate, triggering a gruesome ritual.\nThe cave walls shift, revealing a monstrous lurker with tentacles that lash out and wrap around your body.\nYou are dragged towards a sacrificial altar, the lurker's maw opening wide to consume you in a gruesome display of cave-dwelling savagery.\n",
	};

	private static String[] CLOSE_MESSAGES = {
			"A chill crawls down your spine, and you sense unseen eyes upon you...",
			"A low growl echoes through the darkness, sending shivers down your spine...",
			"The air grows heavy and oppressive, and you feel a malevolent presence draw near...",
			"A sudden gust of wind extinguishes your torch, plunging you into darkness and leaving you vulnerable...",
			"An unseen hand brushes against yours, sending a jolt of icy fear through your veins...",
			"The air feels charged with an unseen energy, crackling with a raw power that threatens to overwhelm you...",
	};

	private static String[] FAR_MESSAGES = {
			"A faint whisper brushes against your ear, carrying words that speak of forgotten horrors...",
			"A disembodied laugh echoes through the cavern, its chilling sound resonating with ancient malice...",
			"A premonition washes over you, a chilling vision of your own demise echoing within your mind...",
			"The darkness seems to press against you, suffocating and heavy, as if trying to consume you whole.",
			"A deep, guttural rumble echoes through the cave, shaking the very foundations of the earth...",
			"The shadows dance and writhe on the walls, morphing into grotesque shapes that fuel your deepest fears...",
	};

	// Public Variables

	// Private Variables

	// Constructor

	// Public Static Methods
	/**
	 * Returns a formatted backstory that matches the player name
	 * 
	 * @param playerName The name of the {@link Player}
	 * @return {@link String}
	 */
	public static String getRandomBackstoryString(String playerName) {
		return Story.BACKSTORY_TEXT_TEMPLATE[(int) (Math.random() * Story.BACKSTORY_TEXT_TEMPLATE.length)]
				.replaceAll("\\[%PLAYER_NAME%\\]", playerName);
	}

	/**
	 * Returns a "Neutral" idle string to present after a given action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomNeutralIdleString() {
		return Story.NEUTRAL_IDLE_TEXT[(int) (Math.random() * Story.NEUTRAL_IDLE_TEXT.length)];
	}

	/**
	 * Returns a "Neutral" movement string to present while doing a movement action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomNeutralMovementString() {
		return Story.NEUTRAL_MOVEMENT_TEXT[(int) (Math.random() * Story.NEUTRAL_MOVEMENT_TEXT.length)];
	}

	/**
	 * Returns a "Positive" movement string to present while doing a movement action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomPositiveMovementString() {
		return Story.POSITIVE_MOVEMENT_TEXT[(int) (Math.random() * Story.POSITIVE_MOVEMENT_TEXT.length)];
	}

	/**
	 * Returns a "Negative" movement string to present while doing a movement action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomNegativeMovementString() {
		return Story.NEGATIVE_MOVEMENT_TEXT[(int) (Math.random() * Story.NEGATIVE_MOVEMENT_TEXT.length)];
	}

	/**
	 * Returns a "Positive" hopeful status string to present while doing a movement
	 * action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomPositiveStatusString() {
		return Story.POSITIVE_STATUS_TEXT[(int) (Math.random() * Story.POSITIVE_STATUS_TEXT.length)];
	}

	/**
	 * Returns a "Negative" hopeful status string to present while doing a movement
	 * action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomNegativeStatusString() {
		return Story.NEGATIVE_STATUS_TEXT[(int) (Math.random() * Story.NEGATIVE_STATUS_TEXT.length)];
	}

	/**
	 * Returns a choice title to represent when choosing an action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomChoiceTitleString() {
		return Story.CHOICE_TITLES[(int) (Math.random() * Story.CHOICE_TITLES.length)];
	}

	/**
	 * Returns a choice title to represent when choosing an action
	 * 
	 * @return {@link String}
	 */
	public static String getRandomActionTitleString() {
		return Story.ACTION_TITLES[(int) (Math.random() * Story.ACTION_TITLES.length)];
	}

	/**
	 * Returns a random amount of movement options
	 * 
	 * @return {@link String[][]}
	 */
	public static String[][] getRandomMovementOptionsString() {
		// Generate a random amount of options
		int amount = (int) Math.round((Math.random() + 1) * 4);

		// Create the output array
		String[][] out = new String[amount][2];

		// Loop
		for (int i = 0; i < amount; i++) {
			// Get a random choice
			String[] newChoiceArray = Story.AVAILABLE_MOVEMENT_OPTIONS[(int) (Math.random()
					* Story.AVAILABLE_MOVEMENT_OPTIONS.length)];

			// Handle index 0 exception
			if (i == 0) {
				out[i] = newChoiceArray;
				continue;
			}

			// Get the choice strings
			String previousChoiceString = out[i - 1][0];
			String newChoiceString = newChoiceArray[0];

			// Check
			if (!previousChoiceString.equals(newChoiceString)) {
				out[i] = newChoiceArray;
				continue;
			}

			// Repeat this index
			i -= 2;
		}

		// Return
		return out;
	}

	/**
	 * Returns a random escape message
	 * 
	 * @return {@link String}
	 */
	public static String getRandomEscapeString() {
		return Story.WIN_MESSAGES[(int) (Math.random() * Story.WIN_MESSAGES.length)];
	}

	/**
	 * Returns a random death message
	 * 
	 * @return {@link String}
	 */
	public static String getRandomDeathString() {
		return Story.DEATH_MESSAGES[(int) (Math.random() * Story.DEATH_MESSAGES.length)];
	}

	public static String getRandomFarMessageString() {
		return Story.FAR_MESSAGES[(int) (Math.random() * Story.FAR_MESSAGES.length)];
	}

	public static String getRandomCloseMessageString() {
		return Story.CLOSE_MESSAGES[(int) (Math.random() * Story.CLOSE_MESSAGES.length)];
	}

	// Public Inherited Methods

	// Private Static Methods

	// Private Inherited Methods
}
