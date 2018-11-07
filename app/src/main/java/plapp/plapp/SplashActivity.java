package plapp.plapp;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import plapp.plapp.Database.DataProvider;
import plapp.plapp.Database.DbHelper;
import viralandroid.com.androiduserinterfacetutorial.R;

public class SplashActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper= new DbHelper(this);
        DataProvider dp, dp1, dp2, dp3, dp4, dp5, dp6, dp7, dp8, dp9, dp10, dp11, dp12, dp13, dp14, dp15, dp16, dp17, dp18, dp19, dp20,dp21;
  /*       dp = new DataProvider("0001", BitmapFactory.decodeResource(getResources(), R.drawable.res_akapulko),"Akapulko",
                "Cassia alata Linn., Cassia bracteata L. f., Cassia herpetica Jacq., Cassia rumphiana (DC.) Bojer, Herpetic alata (L.) Raf., Herpetic alata O.F. Cook & G.N. Collins, Senna alata  (L.) Roxb.",
                "Throughout the Philippines", "The seeds used for intestinal parasitism.;Tincture from leaves reported to be purgative.;Decoction of leaves and flowers for cough and as expectorant in bronchitis and asthma. Also used as astringent.;Crushed leaves and juice extract used for ringworm, scabies, eczema, tinea infections, itches, insect bites, herpes.",
                 null,
                 "Pound enough fresh leaves; express (squeeze out) the juice and apply on the affected skin morning and evening. Improvement should be noticed after 2 - 3 weeks of treatment.;Decoction of leaves and flowers used as mouthwash in stomatitis.;Ointment preparation - Wash fresh leaves thoroughly and cut in small pieces. Add one glass of cooking oil or coconut oil to one glass of cut fresh leaves. Fry until crispy. Remove from the heat; strain. Cut 2 white candles (Esperma No. 5) into small pieces. In a cooking pot, pour the strained oil together with the candle pieces; stir until the candle has melted. Pour the mixture into a clean container; cover when cool. Apply the ointment to affected areas twice daily.", null,null);
        dp1 = new DataProvider("0002", BitmapFactory.decodeResource(getResources(), R.drawable.res_ampalaya),
                "Cucumis argyl H. Lev., Cucumis intermedius M. Roem., Momordica charantia Linn., Momordica chinensis Spreng, Momordica elegans Salisb., Momordica indica L., Momordica muricata Willd., Momordica sinensis Spreng., Sicyos fauriei H.Lév.",
                "Throughout the Philippines", "In the Philippines, juice expressed from the green fruit is given for chronic colitis: also used for bacillary dysentery.;Astringent powdered leaves or root decoction can be applied to hemorrhoids.;Leaf juice for cough and as a purgative and anthelminthic to expel intestinal parasites, and for healing wounds.;Seeds also used to expel worms.;The vine or the juice of leaves used as mild purgative for children.;In large doses, the fresh juice is a drastic purgative.;Decoction of roots and seeds used for urethral discharges.;Juice of leaves used for chronic coughs.;Leaves and shoots used as vulnerary.;Sap of leaves used as parasiticide.;Fruit macerated in oil used as vulnerary.;Fruit considered tonic and stomachic; used in rheumatism, gout, and diseases of the spleen and liver.;Pounded leaves used for scalds.;Infusion of leaves or leaf juice used for fevers.;Used for chronic stomach ulcers.;Root sometimes used as ingredient in aphrodisiac preparations.;Decoction of root used as abortifacient.;Fruit in large doses considered a drastic purgative and abortifacient.",
                null, "Steam ampalaya tops (upper four leaves) and eat half a cup twice daily. As a decoction, boil six tablespoons of finely chopped leaves in two glasses of water over low fire (for 15 minutes). Drink 1/3 cup, three times a day, 30 minutes before meals. Don't use aluminum pots (clay or enamel only).",
                null,null, "hastate, incised");


        dp2 = new DataProvider(
                "0003",
                BitmapFactory.decodeResource(getResources(), R.drawable.res_garlic),
                "Bawang",
                "Allium controversum Schrad.,Allium longicuspis Regel,Allium ophioscorodon Link,Allium pekinense Prokhanov,Allium sativum Linn.,Porum ophioscorodon (Link) Rchb.,Porum sativum (L.) Rchb. [Illegitimate]",
                "Central Luzon",
                "In the Philippines, bulbs used for hypertension. Also used as diuretic, and eaten fresh or burned for coughs in children.;Arthritis, rheumatism, toothaches: Crush several cloves and rub on affected areas.;Crush clove applied to both temples as poultice for headache.;Crush garlic or cut clove crosswise and rub directly to areas of insect bites.;Decoction of leaves and bulbs for fever and as hypotensive, carminative, expectorant, and antihelmintic.;Juice from freshly crushed garlic used for colds, cough, sore throat, hoarseness, asthma and bronchitis.;Decoction use for tonsillitis.;Steam inhalation of chopped garlic and a teaspoon of vinegar in boiling water used for nasal congestion.;Fresh garlic has been used as a complement to INH therapy for tuberculosis. In Mexico, fresh bulb is eaten as a preventive for tuberculosis.",
                null,
                " For disinfecting wound, crush and juice the garlic bulb and apply. You may cover the afflicted area with a gauze and bandage.;For sore throat, peal the skin and chew for several minutes. Swallow the juice.;For toothaches, crush then bite garlic.;For athlete’s foot, soak feet in salty water then apply garlic juice. Do this 3X day for a week.;Cloves of garlic may be crushed and applied to affected areas to reduce the pain caused by arthritis, toothache, headache, and rheumatism.;Decoction of the bawang bulbs and leaves are used as treatment for fever.;For nasal congestion, steam and inhale: vinegar, chopped garlic, and water.SIMILAR LEAVES:",
                null, "linear, entire");*/

        //   dbHelper.insertLeaf();

//        dp1 = new DataProvider("0001", BitmapFactory.decodeResource(getResources(), R.drawable.res_akapulko),
//                "Akapulko",
//                "Senna alata (L.) Roxb., Cassia alata Linn., Cassia bracteata L. f., Cassia herpetica Jacq., Cassia rumphiana (DC.) Bojer, Herpetic alata (L.) Raf., Herpetic alata O.F. Cook & G.N. Collins, Senna alata  (L.) Roxb.",
//                "Abundant throughout the Philippines in settled areas at low and medium altitudes. ",
//                "ringworm, scabies, eczema, tinea infections, itches, insect bites, herpes. ",
//                "Akapulko is a coarse, erect, branched shrub, 1.5 to 3 meters high. Leaves are pinnate and 40 to 60 centimeters long, with orange rachis on stout branches. Each leaf has 16 to 28 leaflets, 5 to 15 centimeters in length, broad and rounded at the apex, with a small point at the tip. Leaflets gradually increase in size from the base towards the tip of the leaf. Inflorescences are terminal and at the axils of the leaves, in simple or panicled racemes, and 10 to 50 centimeters long. Flowers are yellow, about 4 centimeters inn diameter, at the axils of thin, yellow, oblong, concave bracts which are 2.5 to 3 centimeters long. Pod is rather straight, dark brown or nearly black, about 15 centimeters long and 15 millimeters wide. On both sides of the pods there is a wing that runs the length of the pod. Pod contains 50 to 60 flattened, triangular seeds.",
//
//                "<b>EXTRACT</b><br><i>for ringworm, scabies, eczema, tinea infections, itches, insect bites, herpes</i><br>\n" +
//                        " <br>1. Wash fresh leaves thoroughly and cut in small pieces. <br>2. Add one glass of cooking oil or coconut oil to one glass of cut fresh leaves. <br>3. Fry until crispy.<br>4. Remove from the heat, strain. <br>5. Cut 2 white candles (Esperma No. 5) into small pieces. <br>6. In a cooking pot, pour the strained oil together with the candle pieces, stir until the candle has melted. <br>7. Pour the mixture into a clean container, cover when cool. <br>8. Apply the ointment to affected areas twice daily. ",
//                null, "oblanceolate, oblong, lobed ");


        /*dp2 = new DataProvider("0002", BitmapFactory.decodeResource(getResources(), R.drawable.res_ampalaya),
                "Ampalaya",
                "Momordica charantia Linn., Cucumis argyl H. Lev., Cucumis intermedius M. Roem., Momordica charantia Linn., Momordica chinensis Spreng, Momordica elegans Salisb., Momordica indica L., Momordica muricata Willd., Momordica sinensis Spreng., Sicyos fauriei H.Lév.",
                "Year-round vegetable, extensively cultivated in the Philippines for its bitter edible fruit. Wild forms found in open fields, thickets, and waste places at low and medium altitudes.",
                "Diabetes Liver problems,Rheumatism,Gout,Diarrhea ,Headaches,Disinfects and heals wounds & burns,Cough,Fever,Intestinal worms,Help prevent some type of cancer, skin diseases, wounds and burns ",
                "Ampalaya is a climbing vine, nearly or quite smooth, annual vine. Tendrils are simple, up to 20 centimeters long. Leaves are 2.5 to 10 centimeters in diameter, cut nearly to the base into 5 to 7 lobes, oblong-ovate, variously toothed, and heart-shaped at the base. Male flower is about 12 millimeters long, and is peduncled, with a rounded, green, and about 1 centimeter long bract approximately at the middle. Female flower is yellow flower, about 15 millimeters long, long-stalked with pair of small leaflike bracts at middle or toward base of stalk. Fruit, in cultivated form, is green, fleshy, oblong, cylindric, 15 to 25 centimeters long, pointed at both ends, ribbed and wrinkled, bursting when mature to release seeds; in wild forms, ovoid, about 2 to 4 centimeters long. Seeds are oblong, compressed 10 to 13 millimeters long, and corrugated on the margins. ",

                "<b>EXTRACT</b><br><i>for Diabetes Liver problems,Rheumatism,Gout,Diarrhea ,Headaches,Disinfects and heals wounds & burns,Cough,Fever,Intestinal worms,Help prevent some type of cancer, skin diseases, wounds and burns</i><br><br>1. Wash and finely chop leaves. <br>2. Add six tablespoons of the chopped leaves in two glass of water or 2 glasses of leaves to 4 glasses of water. <br>3. Boil the mixture for 15 minutes in an uncovered pot. <br>4. Let it cool and strain. <br>5. Drink 1/3 cup of the solution 30 minutes before meals 3 times a day. <br><br><br><b>Others: " +
                        "</b><br> - You can also steamed and eat Ampalaya tops (1/2 cup 2 times a day)<br>" +
                        " - Warm the leaves and apply to the afflicted area to treat skin diseases, wounds and burns.",

                null, "cordate, incised ");*/

        dp3 = new DataProvider("0003", BitmapFactory.decodeResource(getResources(), R.drawable.res_atis),
                "Atis", "Annona asiatica Linn., Annona asiatica Vahl., Annona distincta Raeusch., Annona forskahlii DC., Annona squamosa Linn., Guanabanus squamosus M.Gómez ", "Cultivated throughout the Philippines; occasionally spontaneous.", "diarrhea, pain, fainting, infected insect bites, hysteria, lice infestation", "Atis is a small tree 3 to 5 meters in height. Leaves are somewhat hairy when young, oblong, 8 to 15 centimeters long, with a petiole 1 to 1.5 centimeters long. Flowers occur singly in the axils of the leaves, about 2.5 centimeters long, pendulous, hairy, three-angled, light green to yellow. Fruit is large, somewhat heart-shaped, 6 to 9 centimeters long, the outside marked with knobby polygonal tubercles. When ripe, the fruit is light yellowish-green.",
                "\n" +
                        "<b>LEAF DECOCTION</b><br><i>for rheumatic baths to alleviate pain</i><br><br><b>FOR FAINTING AND HYSTERIA</b><br> - Crush fresh leaves and place over nose<br><br>\n" +
                        "<b>INFECTED INSECT BITES</b><br> - pound and extract the juice from one unripe fruit and apply the juice directly to the affected areas, 3 times daily<br><br>\n" +
                        "<b>LICE INFESTATION</b><br><br>1. Shampoo hair with gugo bark or any commercial shampoo daily for one week, with 'suyod' combing twice daily. <br>2. For lice eggs (nits), apply hot vinegar for half an hour after shampooing, then 'suyod' (fine combing) thoroughly. <br>3. Bedtime, pound 1/2 cup of atis seeds and mix with 1/4 cup of oil. Apply mixture thoroughly to the scalp and hair. Wrap the hair and head overnight. Shampoo in the morning and follow with fine tooth combing. Do daily for 3-5 days. <br>4. Paste of the crushed seeds in water, applied to the scalp. The same used as abortifacient applied to the os uteri.\n" +
                        "\n",
                null, "Leaf Shape: Oblong; Leaf Margin: Entire");


        /*dp4 = new DataProvider("0004", BitmapFactory.decodeResource(getResources(), R.drawable.res_garlic),
                "Bawang",
                "Allium sativum L. , Allium controversum Schrad.,Allium longicuspis Regel,Allium ophioscorodon Link,Allium pekinense Prokhanov,Allium sativum Linn.,Porum ophioscorodon (Link) Rchb.,Porum sativum (L.) Rchb. [Illegitimate]",
                "Extensively grown in Batangas, Nueva Ecija, Ilocos Norte, Mindoro, and Cotobato. ",
                "Arthritis, rheumatism, toothaches , Headaches , Insect bites , Athlete's foot , Fever , Colds, cough, sore throat, hoarseness, asthma and bronchitis, Nasal congestion , Digestive problems and gastrointestinal spasms ",
                "Bawang is a low herb, 30 to 60 centimeters high. True stem is much reduced. Bulbs are broadly ovoid, 2 to 4 centimeters in diameter, consisting of several, densely crowded, angular and truncated tubers. Leaves are linear and flat. Umbels are globose, many flowered. Sepals are oblong, greenish white, slightly tinged with purple. Stamens are not exerted from the perianth. ",

                "<b>ARTHRISTIS, RHEUMATISM, TOOTCHACHES</b><br> - Crush several Bawang cloves and rub on affected areas. <br><br><b>HEADACHES</b><br> - Crush one Bawang clove and apply to both temples as poultice. <br><br><b>INSECT BITES</b><br> - Crush Bawang or cut clove crosswise and rub directly to affected area.<br><br><b>ATHLETE'S FOOT</b><br> - Crush Bawang or cut clove crosswise and rub directly to affected area. <br><br><b>FEVER</b><br>Decoction of boiled Bawang leaves and bulbs set to luke warm and applied to the head and body.<br><br><b>COLDS, COUGH, SORE THROAT, HOARSENESS, ASTHMA AND BRONCHITIS, NASAL CONGESTION</b><br> - Steam inhalation of chopped Bawang and a teaspoon of vinegar in boiling water<br><br><b>DIGESTIVE PROBLEMS AND GASTROINTESTINAL SPASMS</b><br> - Drink an infusion of a peeled bawang clove or can also be used as suppository.",
                null, "linear, entire");*/


        dp5 = new DataProvider("0005", BitmapFactory.decodeResource(getResources(), R.drawable.res_bayabas),
                "Bayabas",
                "Psidium guajava Linn. , Guajava pumila (Vahl.) Kuntze,Guajava pyrifera (L.) Kuntze,Myrtus guajava (L.) Kuntze,Psidium angustifolium Lam.,Psidium aromaticum Blanco [Illegitimate],Psidium cujavillus Burm.f.,Psidium cujavus L,Psidium fragrans Macfad.,Psidium guajava Linn.,Psidium guajava Griseb.,Psidium igatemyensis Barb. Rodr.,Psidium intermedium Zipp. ex Blume,Psidium pomiferum Linn.,Psidium prostatum O.Berg,Psidium pumilum Vahl,Psidium pyriferum Linn.,Psidium sapidissimum Jacq.,Psidium vulgare Rich.,Syzygium ellipticum K.Schum. & Lauterb. ",
                "Widely distributed throughout the Philippines in all islands and provinces. Common in backyards and settled areas. In thickets and secondary forests at low altitudes, ascending to at least 1,500 meters.",
                "Antiseptic, astringent & anthelminthic ,Kills bacteria, fungi and ameba, Used to treat diarrhea, nosebleeding, For Hypertension, diabetes and Asthma, Promotes menstruation",
                "Bayabas is a somewhat hairy plant reaching a height of 8 meters. Young branches are 4-angled. Leaves are opposite, oblong to elliptic, and 5 to 1 centimeters long, the apex being pointed, and the base usually rounded. Peduncles are 1- to 3-flowered. Flowers are white, 3 to 3.5 centimeters across, with in-curved petals, coming out solitary or two to three in the leaf axils. Numerous stamens form the attractive part of the flower. Inferior ovaries develop into round or obovoid green fruits 4 to 9 centimeters long, turning yellow on ripening and have edible, aromatic, seedy pulp.",

                "<b>TOOTHACHES</b><br>Chew the leaves in your mouth.<br><br><b>DIARRHEA</b><br>Boil the chopped leaves for 15 minutes in water, and strain. Let cool, and drink a cup every three to four hours.<br><br><b>STOPPING NOSEBLEED</b><br>Densely roll Bayabas leaves, then place in the nostril cavities. <br><br><b>Others:</b><br> - Boil one cup of Bayabas leaves in three cups of water for 8 to 10 minutes. Let cool. <br> - Use decoction as mouthwash, gargle.<br> - Use as wound disinfectant - wash affected areas with the decoction of leaves 2 to 3 times a day. Fresh leaves may be applied to the wound directly for faster healing.\n" ,
                null, "oblong, elliptic, entire");


        /*dp6 = new DataProvider("0006", BitmapFactory.decodeResource(getResources(), R.drawable.res_kangkong),
                "Kangkong", "Ipomoea aquatica Forssk., Ipomoea natans Roth, Ipomoea reptans Poir., Ipomoea sagittifolia Hochr., Ipomoea subdentata Miq.", "Throughout the Philippines in stagnant streams, fresh-water swamps, and pools.", "Reduces Cholesterol, Treatment of Jaundice and Liver Problems, for Anaemia, For Indigestion and Constipation, Anti Diabetic, ", "Kangkong is a smooth, widely spreading vine, with the stems trailing on mud or floating on water. Leaves are oblong-ovate, 7 to 14 centimeters long, with a pointed tip and heart-shaped or arrow-shaped base, long petioled, the margins entire or angular, and sublobed. Peduncles are erect, 2.5 to 5 centimeters long, with 1 or 2 flowers, borne in the axils of the leaves.",
                "-Young leaves and shoots eaten raw in salads, or steam and boiled like spinach<br> - Young stems popular as achara (native pickles) ingredient<br> - Used as laxative and sedative <br> -  used for piles, nervous conditions, headache, insomnia" ,
                null, "oblong, ovate,entire");*/

        /*dp7 = new DataProvider("0007", BitmapFactory.decodeResource(getResources(), R.drawable.res_lagundi),
                "Lagundi",
                "Vitex negundo Linn., Agnus-castus incisa (Lam.) Carriére,Agnus-castus negundo (L.) Carriére,Vitex arborea Desf.,Vitex chinensis Mill.,Vitex elmeri Moldenke,Vitex gracilis Salisb.,Vitex incisa Lam.,Vitex laciniata Schauer,Vitex leucoxylon Blanco [Illegitimate],Vitex negundo Linn.,Vitex sinuata Medik.,Vitex spicata Lour.",
                "Widely distributed in the Philippines. At low and medium altitudes, in thickets and waste places. Flowering year round. Best propagated by use of mature, leafless stem cuttings.",
                " Relief of asthma & pharyngitis, Recommended relief of rheumatism, dyspepsia, boils, diarrhea ,Treatment of cough, colds, fever and flu and other bronchopulmonary disorders,Alleviate symptoms of Chicken Pox ,Removal of worms, and boils",
                "Lagundi is an erect, branched tree or shrub, 2 to 5 meters high. Leaves are usually 5-foliate, rarely with 3 leaflets only, and palmately arranged. Leaflets are lanceolate, entire, 4 to 10 centimeters long, slightly hairy beneath, and pointed at both ends, the middle leaflets being larger than the others, and distinctly stalked. Flowers are numerous, blue to lavender, 6 to 7 millimeters long, borne in terminal inflorescences (panicles) 10 to 20 centimeters long. Calyx is hairy, and 5-toothed. Corolla is densely hairy in the throat, and the middle lobe of the lower lip is longest. Fruit is a succulent drupe, globose, black when ripe, about 4 millimeters in diameter.",
                "<b>SKIN DISEASES OR DISORDERS</b><br>Apply the decoction of leaves and roots directly on skin.<br><br><b>Others: </b><br> - Boil half cup of chopped fresh or dried leavesin 2 cups of water for 10 to 15 minutes. Drinkhalf cup three times a day.<br> - The root is specially good for treating dyspepsia, worms, boils, colic and rheumatism.\n",
                null, " cordate; incised ");*/

        dp8 = new DataProvider("0008", BitmapFactory.decodeResource(getResources(), R.drawable.res_mango),
                "Manga", "Mangifera indica Linn., Mangifera domestica Gaertn., Mangifera sylvatica  F.-Vill.", "Cultivated throughout the Philippines.", "rheumatism and leucorrhea, dysentery, Cough, Diarrhea, menorrhagia, leucorrhea, hemorrhoidal bleeding, and hemorrhage from the lungs, nasal catarrh, and for lumbrici, antisyphilitic, scabies and other parasitic skin diseases", "Manga is a large tree, with a dense and spreading crown. Leaves are oblong to oblong-lanceolate, 10 to 30 centimeters long. The flowers are yellow, small, 3 to 4 millimeters long, borne on erect and hairy panicles, which as as often as long as the leaves. The fruit is a drupe, of varying shades of yellow, fleshy, oblong-ovoid,10 to 15 centimeters long, and slightly compressed, the skin is thin, and in the center is a large flattened, fibrous seed, and when ripe, surrounded by an edible yellow pulp.",
                "<b>AS FLUID EXTRACT</b><br><i>for in menorrhagia, leucorrhea, hemorrhoidal bleeding, and hemorrhage from the lungs, nasal catarrh, and for lumbrici</i><br><br><b>AS SUORIFIC</b><br>Gum resin from the bark and fruit<br><br><b>COUGH</b><br>Drink infusion of young leaves as needed.<br><br><b>DIARRHEA</b><br>Take decoction of bark or kernel as tea<br><br><b>DYSENTERY</b><br>Juice of manga leaves\n",
                null, "oblong, oblong, lanceolate, undulate");

        /*dp9 = new DataProvider("0009",
                BitmapFactory.decodeResource(getResources(), R.drawable.res_niyogniyogan),
                "Niyog-Niyogan",
                "Ficus blancoi, Ficus haenkei Warb., Ficus pseudopalma",
                "Widely distributed in thickets at low altitudes. Occasionally planted for its ornamental leaves. ",
                "Anthelmintic, Expels Intestinal Worms and Parasites, Treatment of Inflammation of Kidneys, Remedy for boils and skin ulcers, Remedy for headaches, Remedy for Diarrhea and Fever, Remedy for Dysuria or painful urination, Anti-Cancer ",
                "Niyog-niyogan is a large climbing, woody shrub reaching a length of 2 to 8 meters. Leaves are oblong to elliptic, opposite, 7 to 15 centimeters long, rounded at the base and pointed at the tip. It has fragrant and colorful flowers. Niyog-niyogan flowers exhibit varying colors, from white, red, reddish purple, pink red to orange that sprouts into clusters. ",

                "<b>ANTHELMINTIC</b><br>The seeds of Niyog-niyogan are dried and taken orally. Recommended dosage is 4 to 7 seeds for Children while 8 to 10 seeds for Adults<br><br><b>TREATMENT OF INFLAMMATION OF KIDNEYS</b><br>Niyog-niyogan fruits are believed to alleviate nephritis or inflammation of the kidneys<br><br><b>BOILS AND SKIN ULCERS</b><br>Niyog-niyogan leaves are pounded and applied to externally to skin ulcers and boils<br><br><b>HEADACHES</b><br>Niyog-niyogan leaves are applied to the head to relieve headaches.<br><br><b>DIARRHEA AND FEVER</b><br>ripe fruits of Niyog-niyogan are roasted and taken internally for diarrhea and fever treatment<br><br><b>DYSURIA OR PAINFUL URINATION</b><b>A decoction of boiled Niyog-niyogan leaves are taken as tea to relieve pain while urinating. Boil enough leaves and make water as tea. Or dry the leaves and make them into tea</b>",
                null,  "oblong, elliptic, entire ");*/

        dp10 = new DataProvider("0010", BitmapFactory.decodeResource(getResources(), R.drawable.res_oregano),
                "Oregano", "Coleus amboinicus Lour., Coleus aromaticus Benth., Coleus suganda Blanco, Plectranthus aromaticus Roxb., Plectranthus amboinicus (Lour.) Sprengel", "Cultivated for its aromatic leaves", "Cold, Muscle pain, Acne, Dandruff, Toothache, Headaches, Allergies, Intestinal parasites, Menstrual cramps ", "Oregano is an erect, spreading, branched, rather coarse, strongly aromatic, green herb, with fleshy stems. Leaves are fleshy, broadly ovate, 4 to 9 centimeters long, often heart-shaped, and somewhat hairy, with rounded toothed margins, with the tip and base decurrent. Flowers are small, and occur in distant whorls.",
                "<b>BURNS</b><br>Macerated fresh leaves applied externally to burns<br><br><b>BITES AND HEADACHES</b><br>Leaves are bruised and applied to centipede and scorpion bites. Also, applied to temples and forehead for headache, help in place by a bandage<br><br><b>ASTHMA</b><br>Leaves in infusion or as syrup used as aromatic and carminative<br><br><b>DYSPEPSIA, ASTHMA, CHRONIC COUGHS, BRONCHITIS, COLIC, FLATULENCE, RHEUMATISM</b><br>Juice of the leaves, The dose is one tablespoonful of the fresh juice every hour for adults and one teaspoonful every two hours, four times daily, for children. As an infusion, 50 to 60 grams to a pint of boiling water, and drink the tea, 4 to 5 glasses a day.<br> For children, 1/2 cup 4 times daily<br><br><b>OTALGIA</b><br> - Pour the fresh, pure juice into the ear for 10 minutes.<br><br><b>CARBUNCLES, BOILS, SPRAINS, FELONS, PAINFUL SWELLINGS</b><br>Apply the poultice of leaves to the affected area, four times daily<br><br><b>SORE THROATS</b><br>a decoction of two tablespoonfuls of dried leaves to a pint of boiling water, taken one hour before or after meals.",
                null,"ovate, crenate");

        dp11 = new DataProvider("0011", BitmapFactory.decodeResource(getResources(), R.drawable.res_panda),
                "Pandan", "Corypha laevis (Lour.) A.Chev., Pandanus inermis Roxb., Pandanus spurius (Willd.) Miq., Pandanus trukensis Kaneh.", "In thickets along seashores throughout the Philippines.", "headaches, wounds, abscesses, arthritis, strengthens the gums, blennorhea, boils", "is a genus of monocots of about 600 known species, varying in size from small shrubs less than a meter to medium-sized trees of about 20 meters.In the Philippines there are 48 species of Pandanus, many of them are endemic, growing in various habitats, from sandy beaches, mangroves and primary forests. The fruit of some species are edible, eaten by bats, rats, crabs, elephants and lizards. The majority of species are dispersed primarily by water.",
                "<b>HEADACHES</b><br>Poultice of fresh leaves mixed with oil also used for headaches<br><br><b>ABSCESSES</b><br>Poultice of mash of cabbage of plant, mixed with salt and juice of Citrus microcarpa<br><br><b>ARTHRITIS</b><br>Decoction of roots believed to have aphrodisiac and cardiotonic properties <br><br><b>BLENNORHEA</b><br> - Decoction of aerial roots use as beverage for cases of blennorrhea<br><br><b>BOILS</b><br>Leaves of plant triturated into a mash, slightly salted and added with juice of Citrus microcarpa, used as hot poultice <br><br><b>Others:</b><br> - Chewing the roots strengthens the gums",
                null,"gladiate, entire");


        //dp12 = new DataProvider("0012", BitmapFactory.decodeResource(getResources(), R.drawable.res_ulasimang),
        //        "Pansit-Pansitan/ Ulasimang Bato ",
        //        "Micropiper pellucidum, Peperomia concinna, Peperomia knoblecheriana, Piper concinnum, Verhuellia knoblocheriana ",
        //        "An annual herb, favoring shady, damp and loose soil, Often grows in groups in nooks in the garden and yard., Conspicuous in rocky parts of canals. ",
        //        "Eye inflammation, Sore throat, Diarrhea, Prostate problems, High blood pressure, Arthritis, Gout, Skin boils, Wounds, Burns, Skin inflammation, abscesses, pimples, Headache Fever, Abdominal pains , Renal problems, Mental excitement disorder ",
        //        "Pansit-pansitan is characterized by its shiny heart shaped leaves about 4 cm in length, growing from an erect translucent green stalks. Pansit-pansitan has tiny dot-like flowers that grow from erect and slender green spikes that turn brown when matured. The fruits are also very small, round to oblong, ridged, first green later black. Tiny seeds drop off that grows easily in groups. ",
//
        //        "<b>GOUT</b><br>Infusion and decoction of leaves and stems<br><br><b>URINARY TRACT INFECTIONS</b><br>Decotion of leaves<br><br><b>COMPLEXION PROBLEMS</b><br>Externally, as a facial rinse<br><br><b>BOILS, PUSTULES AND PIMPLES</b><br>Pounded whole plant used as warm poultice<br><br><b>EYE INFLAMMATION</b><br>Solution of fresh juice of stem and leaves<br><br><b>FEVER</b><br>Decoction of roots<br><br><b>ARTHRITIS</b><br>Leaves and stems of the fresh plant may be eaten as salad. Or, as an infusion, put a 20-cm plant in 2 glasses of boiling water<br><i>-1/2 cup of this infusion is taken morning and evening</i>",
        //        null, "cordate, entire ");
//
        //dp13 = new DataProvider("0013", BitmapFactory.decodeResource(getResources(), R.drawable.res_pechay),
        //        "Pechay",
        //        "Barbarea derchiensis S.S. Ying., Brassica asperifolia Lam., Brassica briggsii Varenne., Brassica coiza H. Lév., Caulanthus sulfureus Payson",
        //        "Cultivated in the Philippines, grown from low to mid elevations throughout the year.",
        //        "breast tumors, cancer remedy",
        //        "Pechay is an erect, biennial herb, growing about 15 to 30 centimeters tall in vegetative state. Leaves are ovate, spreading, and arranged spirally. Petioles are enlarged, growing upright forming a subcylindrical bundle. Inflorescence is a raceme with pale yellow flowers. Seeds are 1 millimeter in diameter, reddish to blackish brown in color.",
        //        "<b>CANCER REMEDY</b><br>Use stems, leaves and powdered Pechay seed<br><br><b>BREAST TUMOR</b><br>Boil Pechay roots",
        //        null, "ovate, entire");
//
        //dp14 = new DataProvider("0014", BitmapFactory.decodeResource(getResources(), R.drawable.res_repolyo),
        //        "Repolyo",
        //        "Brassica oleracea Linn. var. Capitata",
        //        "Cultivated from seeds.",
        //        "chronic coughs, bronchitis, asthma, blisters, warts",
        //        "Repolyo is the head-bearing or true cabbage, a biennial herb. Main axis is short and thick, the leaves are densely packed, and as it grows, close and develop into a gigantic bud of head. There are various forms of cabbage shapes: flat, round, egg-shaped, oval, or conical. Leaves vary in color, from the common light yellowish green to dark green and dark red.",
        //        "<b>CHRONIC COUGHS, BRONCHITIS, ASTHMA</b><br>Juice of red cabbage<br><br>\n" +
        //                "<b>WART</b><br>Juice of white cabbage<br><br><b>Others:</b>\n" +
        //                "<br> - Bruised leaves of the common white cabbage used for blisters.\n",
        //        null, "orbicular, undulate");
        //dp15 = new DataProvider("0015", BitmapFactory.decodeResource(getResources(), R.drawable.res_sambong),
        //        "Sambong",
        //        "Blumea balsamifera, Baccharis balsamifera, Baccharis gratissima, Blumea grandis, Conyza appendiculata, Conyza balsamifera, Conyza saxatilis, Pulchea appendiculata, Pulchea balsamifera ",
        //        "Common in open fields, grasslands and waste areas at low and medium altitudes ",
        //        "Fevers, Abscesses, kidney stones, and cystitis, Rheumatism, Headaches, Colds and Coughs, Diarrhea, Cuts and Wounds, sinusitis, asthmatic bronchitis, influenza ",
        //        "Sambong is a half woody, strongly aromatic shrub, densely and softly hairy, 1 to 4 meters high. Stems grow up to 2.5 centimeters in diameter. Leaves are simple, alternate, elliptic- to oblong-lanceolate, 7 to 20 centimeters long, toothed at the margins, pointed or blunt at the tip, narrowing to a short petiole. Sambong has yellow flowering heads that is 6 mm long. Sambong bears fruits that are ribbed and hairy on top. Sambong fruit has 1 seed. ",
//
        //        "<b>DECOTION PREPARATION</b><br>Thoroughly wash the leaves of tsaang gubat in running water. Chop to a desirable size and boil 1 cup of chopped leaves in 2 cups of water. Boil in low heat for 15 to 20 minutes and drain<br><br><b>FEVER</b><br>Crushed Sambong leaves must be soaked in cold water, wrung out and placed between sheets of clean cloth. The cloth plaster may then be placed on the patient’s forehead or armpit to lower the body temperature and prevent convulsions<br><br><b>RHEUMATISM</b><br>Sambong roots and leaves are pounded and applied as poultice on the affected body part. Sambong roots and leaves may also be boiled and are applied as warm compress onto affected area\n" +
        //                "<br><br><b>HEADACHE</b>Apply crushed and pounded leaves on forehead and temples.<br><br><b>CUTS AND WOUNDS</b><br>Fresh juice of leaves to wounds<br><br><b>COLD, COUGH, DIARRHEA</b><br>You may gather fresh leaves and chop them into small pieces then wash under running water thoroughly. Toss the chopped leaves into a liter of boiling water. Steep the leaves for 10 minutes then let the tea cool. The tea may be taken four times a day",
        //        null, "elliptic, oblong, lanceolate, serrulate ");
//
        //dp16 = new DataProvider("0016", BitmapFactory.decodeResource(getResources(), R.drawable.res_tsaanggubat),
        //        "Tsaang Gubat",
        //        "Carmona retusa, Ehretia microphylla Lam., Carmona heterophylla Cav., Ehretia buxifolia Roxb., Ehretia heterophylla Spreng. ",
        //        "Easily found from the Batan Islands and northern Luzon to Palawan and Mindanao, in most or all islands and provinces, in thickets and secondary forests at low and medium altitudes. ",
        //        "Allergy, canker sores, colic, cough, diarrhea, diabetes, dysentery, eczema, gastroenteritis, itching, inflammation, scabies, skin diseases, stomach problems, teething problems and wounds ",
        //        "Tsaang gubat is an erect, very branched shrub growing up to 1 to 4 meters high. Leaves are in clusters on short branches, obovate to oblong-obovate, 3 to 6 centimeters long, entire or somewhat toothed or lobed near the apex and pointed at the base, short stalked and rough on the upper surface. Tsaang gubat bears small white flowers, axillary, solitary, 2 or 4 on a common stalk. It bears yellow fruits when ripe about 4-5 mm in diameter, fleshy, with a 4-seeded stone. ",
//
        //        "<b>ABDOMINAL COLIC, COUGH, AND DYSENTERY</b><br>Leaf decoction or infusion. <br><br><b>DIARRHEA</b><br>1. Boil 8 tbsp of chopped leaves in 2 glasses of water for 15 minutes, then strain and cool. <br><br><b>DIABETES</b><br> - 50 gm of fresh leaves or roots are chopped <br> - 100 cc of water is added, and 120 cc of juice is extracted by squeezing, and given once or twice daily<br><br><b>Others</b><br> - Decoction of leaves used as disinfectant wash after childbirth.<br> - Gargle for stronger teeth and prevent cavities <br> -  Use 1/4 of the decoction every 2 or 3 hours <br> - for treatment of back pain and numbness of hands and feet: dry roots and stems\n",
        //        null, "obovate, oblong, lobed");
//
        //dp17 = new DataProvider("0017", BitmapFactory.decodeResource(getResources(), R.drawable.res_tuba),
        //        "Tuba", "Croton tiglium Linn.,Croton acutus Thunb. ,Croton arboreus Shecut ,Croton bimanicus Müll. Arg ,Croton camaza Perr. ,Croton himalaicus D.G. Long ,Croton pavana Buch.-Ham. ,Croton tiglium Linn. ,Halecus verus Raf. ,Kurkas tiglium (L.) Raf. ,Oxydectes pavana (Buch.-Ham) Kuntze ,Oxydectes tiglium (L.) Kuntze ,Tiglium officinale Klotz.", "Usually planted, in and about towns, throughout the Philippines", "Bruise,Sprained ankle", "Tuba is an erect or more or less spreading shrub or very small tree. Leaves are alternate, ovate 7 to 12 centimeters in length, usually somewhat rounded at the base, pointed at the tip and toothed at the margins. Flowers are very small, borne on terminal inflorescences, with the female flowers situated toward the base of each inflorescence. Fruits is a capsule, ellipsoid or obscurely 3-angled, 1.5 to 2 centimeters long and contains a single seed. Seeds are ovoid or oblong, 12 to 15 millimeters in length and 3-angled, the testa dark-brown or blackish, thin and brittle and of faint odor; the albumen and the embryo are yellowish. Seeds are at first mild in taste and subsequent acrid and pungent.",
        //        "  <b>AS A PATCH</b><br><i>for bruise, sprained ankle</i></b><br><br>1. Wash the leaves <br>2. Wipe it dry with clean cloth. <br>3. Heat it in a low fire, then put some oil, natural oil from coconut is better, others use efficascent oil. <br>4. Put it in affected area, wrap some used cloth or bandage. Replace it when the leaves are dry or brittle." ,
        //        null, "elliptical,entire");

        //dp18 = new DataProvider("0018",
        //        BitmapFactory.decodeResource(getResources(), R.drawable.res_uray),
        //        "Uray",
        //        "Amaranthus spinosus Linn.,Amaranthus spinosus Linn.,Amaranthus spinosus var. basiscissus Thell.,Amaranthus spinosus var. circumscissus Thell.,Amaranthus spinosus var. indehiscens Thell.,Amaranthus spinosus var. purpuascens Moq.,Amaranthus spinosus var. rubricaulis Hassk.,Galliaria spitosa (L.) Nieuwl.",
        //        "Weed found throughout the Philippines at lowlands and low altitudes, in open waste place, gregarious and abundant along sand bars and margins of streams.",
        //        " Neisseria Gonorrhea,Eczema,Eruptive Fevers, Antidote for snake-poison,Lactagogue,Breathing in acute bronchitis,Diuretic,Menorrhagia,",
        //        "Urai is a stout, erect, smooth, branched herb, 0.4 to 1 meter high. Stems are armed with slender, axillary spines. (The presence of spines differentiate it from kolitis (Amaranthus viridis). Leaves are glabrous, long-petioled, oblong to oblong ovate, or elliptic-lanceolate, 4 to 10 centimeters long, obtuse, alternate. Flowers are very numerous, stalkless, green or greening-white, about 1 millimeter long, and borne in dense, axillary clusters and in elongated terminal axillary spikes. Sepals are 5 or 1-3, ovate to linear, often aristate. Petals are scarious. Bracts are linear, bristle-pointed and as long as the sepals or longer. Fruits are utricles, wrinkled, nearly as long as the sepals. Seeds are minute, black and shining.",
        //        "Decoction of the root is useful in the treatment of gonorrhea. A common venereal disease caused by the bacterium Neisseria gonorrhoeae; symptoms are painful urination and pain around the urethra.;Bruised leaves are used locally for eczema. Generic term for inflammatory conditions of the skin; particularly with vesiculation in the acute stages.;Plant is used as a sudorific and febrifuge and is recommended in eruptive fevers.;Used as an antidote for snake-poison and as a lactagogue (enhance production of mother’s breastmilk).;The plant is used as an expectorant and to relieve breathing in acute bronchitis.;The root is known elsewhere as an effective diuretic. It is also useful in treatment of menorrhagia, an abnormally heavy or prolonged menstruation; can be a symptom of uterine tumors and can lead to anemia if prolonged." ,
        //        null, "oval, entire");
//
//
        //dp19 = new DataProvider("0019", BitmapFactory.decodeResource(getResources(), R.drawable.res_yerba),
        //        "Yerba Buena",
        //        "Mentha arvensis, Calamintha arvensis, Mentha parietariifolia ",
        //        "Widely cultivation to some extent in all parts of the Philippines. Thrives well at high elevations; rarely flowers in lowlands. ",
        //        "Dental Care, Headaches, toothaches, Dizziness, Wounds, Treatment of Cold, Treatment of Rheumatism, Relief from Menstrual Pain, Insects Bites, Nausea, Analgesic, Asthma ",
        //        "Yerba buena is a prostrate, smooth , much-branched, usually purplish, strongly aromatic herb, with stems growing up to 40 centimeters long, with ultimate ascending terminal branches. Leaves are elliptic to oblong-ovate, 1.5 to 4 centimeters long, short-stalked with toothed margins, and rounded or blunt tipped. Flowers are hairy and purplish to bluish, borne in axillary headlike whorls. Calyx teeth are triangular or lanceolate and hairy; the corolla is also hairy. ",
//
        //        "<b>DENTAL CARE</b><br><i>swollen gums, tooth aches, mouth wash</i><br><br>steep 6 grams of fresh plant in a glass of boiling water for 30 minutes. Use solution as gargle\n" +
        //                "<br><br><b>ANALGESIC</b><br> boil a handful of yerba leaves with a cup of water for 15 mins. Allow the drink to cool down before drinking. Repeat the process every 3 to 4 hours for relief<br><br>\n" +
        //                "<b>HEADACHE</b><br>1. Slightly heat up the leaves over the fire. <br>2. Place the heated leaves over the forehead and temples for 15 to 20 minutes. <br>3. Repeat the process at a 4-hour interval until the headache stops<br><br>\n" +
        //                "<b>TOOTHACHES</b><br>1. Wash and squeeze some fresh yerba buena leaves. <br>2. Add the juice on a cotton wool. <br>3. Place the cotton wool on the affected tooth for 10 to 15 mins. <br>4. Remove the cotton wool and rinse mouth with clean water.<br><br>\n" +
        //                "<b>DIZZINIESS</b><br>The leaves can be squeezed and placed over the nose for 10 to 20 mins. During this period, the fresh droplets from the leaves are gradually inhaled to stop dizziness.<br><br>\n" +
        //                "<b>WOUNDS</b><br>The stems of yerba buena can be crushed to form a poultice. The poultice can be applied on wounds, bruises, abrasions and cuts for healing.<br><br>\n" +
        //                "<b>COLD</b><br>Wash fresh Yerba Buena leaves in running water. Chop to size for dried leaves, crush) and boil 2 teaspoons of leaves in a glass of water. Boil in medium heat for 15 to 20 minutes<br><br>\n" +
        //                "<b>RHEUMATISM</b><br>1.  crush the fresh leaves squeeze sap <br>2. Massage sap on painful parts with eucalyptus. <br><br>\n" +
        //                "<b>INSECT BITES</b><br>1.  crush leaves and apply juice on affected part or pound leaves until paste-like.  <br>2. Then rub this on affected part.<br>" +
        //                "<b>NAUSEA AND ASTHMA</b><br>The leaves can also be crushed before the nostrils thus the scent can be inhaled<br><br>\n",
        //        null, "oblong,ovate,serrate");


        //dp20 = new DataProvider("0020", BitmapFactory.decodeResource(getResources(), R.drawable.res_yerba),
        //        "Malunggay",
        //        "Mentha arvensis, Calamintha arvensis, Mentha parietariifolia " + "asasasasadasdsadsad",
        //        "Widely cultivation to some extent in all parts of the Philippines. Thrives well at high elevations; rarely flowers in lowlands. ",
        //        "Dental Care, Headaches, toothaches, Dizziness, Wounds, Treatment of Cold, Treatment of Rheumatism, Relief from Menstrual Pain, Insects Bites, Nausea, Analgesic, Asthma ",
        //        "Yerba buena is a prostrate, smooth , much-branched, usually purplish, strongly aromatic herb, with stems growing up to 40 centimeters long, with ultimate ascending terminal branches. Leaves are elliptic to oblong-ovate, 1.5 to 4 centimeters long, short-stalked with toothed margins, and rounded or blunt tipped. Flowers are hairy and purplish to bluish, borne in axillary headlike whorls. Calyx teeth are triangular or lanceolate and hairy; the corolla is also hairy. ",
//
        //        "For Dental Care (swollen gums, tooth aches, mouth wash): steep 6 grams of fresh plant in a glass of boiling water for 30 minutes. Use solution as gargle; For Analgesic: boil a handful of yerba leaves with a cup of water for 15 mins. Allow the drink to cool down before drinking. Repeat the process every 3 to 4 hours for relief; For Headache: (1) Slightly heat up the leaves over the fire. (2) Place the heated leaves over the forehead and temples for 15 to 20 minutes. (3) Repeat the process at a 4-hour interval until the headache stops; For Toothaches: (1) Wash and squeeze some fresh yerba buena leaves. (2) Add the juice on a cotton wool. (3) Place the cotton wool on the affected tooth for 10 to 15 mins. (4) Remove the cotton wool and rinse mouth with clean water; For Dizziness: The leaves can be squeezed and placed over the nose for 10 to 20 mins. During this period, the fresh droplets from the leaves are gradually inhaled to stop dizziness; For Wounds: The stems of yerba buena can be crushed to form a poultice. The poultice can be applied on wounds, bruises, abrasions and cuts for healing; For Colds: Wash fresh Yerba Buena leaves in running water. Chop to size for dried leaves, crush) and boil 2 teaspoons of leaves in a glass of water. Boil in medium heat for 15 to 20 minutes; For Rheumatism: (1) crush the fresh leaves squeeze sap (2) Massage sap on painful parts with eucalyptus; For Insects Bites: (1) crush leaves and apply juice on affected part or pound leaves until paste-like.  (2) Then rub this on affected part; For Nausea and Asthma: The leaves can also be crushed before the nostrils thus the scent can be inhaled; ",
        //        null, "oblong,ovate,serrate");
//
        //dp21 = new DataProvider("0021", BitmapFactory.decodeResource(getResources(), R.drawable.res_bayabas),
        //        "Kamatis",
        //        "Psidium guajava Linn. , Guajava pumila (Vahl.) Kuntze,Guajava pyrifera (L.) Kuntze,Myrtus guajava (L.) Kuntze,Psidium angustifolium Lam.,Psidium aromaticum Blanco [Illegitimate],Psidium cujavillus Burm.f.,Psidium cujavus L,Psidium fragrans Macfad.,Psidium guajava Linn.,Psidium guajava Griseb.,Psidium igatemyensis Barb. Rodr.,Psidium intermedium Zipp. ex Blume,Psidium pomiferum Linn.,Psidium prostatum O.Berg,Psidium pumilum Vahl,Psidium pyriferum Linn.,Psidium sapidissimum Jacq.,Psidium vulgare Rich.,Syzygium ellipticum K.Schum. & Lauterb. ",
        //        "Widely distributed throughout the Philippines in all islands and provinces. Common in backyards and settled areas. In thickets and secondary forests at low altitudes, ascending to at least 1,500 meters.",
        //        "Antiseptic, astringent & anthelminthic ,Kills bacteria, fungi and ameba, Used to treat diarrhea, nosebleeding, For Hypertension, diabetes and Asthma, Promotes menstruation",
        //        "Bayabas is a somewhat hairy plant reaching a height of 8 meters. Young branches are 4-angled. Leaves are opposite, oblong to elliptic, and 5 to 1 centimeters long, the apex being pointed, and the base usually rounded. Peduncles are 1- to 3-flowered. Flowers are white, 3 to 3.5 centimeters across, with in-curved petals, coming out solitary or two to three in the leaf axils. Numerous stamens form the attractive part of the flower. Inferior ovaries develop into round or obovoid green fruits 4 to 9 centimeters long, turning yellow on ripening and have edible, aromatic, seedy pulp.",
//
        //        "<b>EXTRACT</b><br><i>for Diabetes Liver problems,Rheumatism,Gout,Diarrhea ,Headaches,Disinfects and heals wounds & burns,Cough,Fever,Intestinal worms,Help prevent some type of cancer, skin diseases, wounds and burns</i><br><br>1. Wash and finely chop leaves. <br>2. Add six tablespoons of the chopped leaves in two glass of water or 2 glasses of leaves to 4 glasses of water. <br>3. Boil the mixture for 15 minutes in an uncovered pot. <br>4. Let it cool and strain. <br>5. Drink 1/3 cup of the solution 30 minutes before meals 3 times a day. <br><br><br><b>Others: " +
        //                "</b><br> - You can also steamed and eat Ampalaya tops (1/2 cup 2 times a day)<br>" +
        //                " - Warm the leaves and apply to the afflicted area to treat skin diseases, wounds and burns.",
//
        //        null, "oblong, elliptic, entire");



        if(dbHelper.checkTable()==false){
            //dbHelper.insertLeaf(dp1);
            //dbHelper.insertLeaf(dp2);
            dbHelper.insertLeaf(dp3);
            //dbHelper.insertLeaf(dp4);
            dbHelper.insertLeaf(dp5);
//            dbHelper.insertLeaf(dp6);
//            dbHelper.insertLeaf(dp7);
            dbHelper.insertLeaf(dp8);
//            dbHelper.insertLeaf(dp9);
            dbHelper.insertLeaf(dp10);
            dbHelper.insertLeaf(dp11);
//            dbHelper.insertLeaf(dp12);
//            dbHelper.insertLeaf(dp13);
//            dbHelper.insertLeaf(dp14);
//            dbHelper.insertLeaf(dp15);
//            dbHelper.insertLeaf(dp16);
//            dbHelper.insertLeaf(dp17);
//            dbHelper.insertLeaf(dp19);
        }



        //dbHelper.deleteRow();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
