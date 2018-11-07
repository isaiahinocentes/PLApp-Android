package plapp.plapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import viralandroid.com.androiduserinterfacetutorial.R;

public class PictureSearchResult extends AppCompatActivity {

    String leaf_info[] = {
            //Atis
            "ATIS\nAnnona asiatica Linn., Annona asiatica Vahl., Annona distincta Raeusch., Annona forskahlii DC., Annona squamosa Linn., Guanabanus squamosus M.Gómez. Cultivated throughout the Philippines; occasionally spontaneous.",
            //Bayabas
            "BAYABAS\nPsidium guajava Linn. , Guajava pumila (Vahl.) Kuntze,Guajava pyrifera (L.) Kuntze,Myrtus guajava (L.) Kuntze,Psidium angustifolium Lam.,Psidium aromaticum Blanco [Illegitimate],Psidium cujavillus Burm.f.,Psidium cujavus L,Psidium fragrans Macfad.,Psidium guajava Linn.,Psidium guajava Griseb.,Psidium igatemyensis Barb. Rodr.,Psidium intermedium Zipp. ex Blume,Psidium pomiferum Linn.,Psidium prostatum O.Berg,Psidium pumilum Vahl,Psidium pyriferum Linn.,Psidium sapidissimum Jacq.,Psidium vulgare Rich.,Syzygium ellipticum K.Schum. & Lauterb. Bayabas is a somewhat hairy plant reaching a height of 8 meters. Young branches are 4-angled. Leaves are opposite, oblong to elliptic, and 5 to 1 centimeters long, the apex being pointed, and the base usually rounded. Peduncles are 1- to 3-flowered. Flowers are white, 3 to 3.5 centimeters across, with in-curved petals, coming out solitary or two to three in the leaf axils. Numerous stamens form the attractive part of the flower. Inferior ovaries develop into round or obovoid green fruits 4 to 9 centimeters long, turning yellow on ripening and have edible, aromatic, seedy pulp.",
            //Mangga
            "MANGGA\nMangifera indica Linn., Mangifera domestica Gaertn., Mangifera sylvatica  F.-Vill. Cultivated throughout the Philippines.",
            //Oregano
            "OREGANO\nColeus amboinicus Lour., Coleus aromaticus Benth., Coleus suganda Blanco, Plectranthus aromaticus Roxb., Plectranthus amboinicus (Lour.) Sprengel Cultivated for its aromatic leaves",
            //Pandan
            "PANDAN\nCorypha laevis (Lour.) A.Chev., Pandanus inermis Roxb., Pandanus spurius (Willd.) Miq., Pandanus trukensis Kaneh. In thickets along seashores throughout the Philippines."
            };

    String leaf_use[] = {
            "Leaf decoction used for rheumatic baths to alleviate pain; For fainting and hysteria: crush fresh leaves and place over nose; For infected insect bites: pound and extract the juice from one unripe fruit and apply the juice directly to the affected areas, 3 times daily; For lice infestation: (1)Shampoo hair with gugo bark or any commercial shampoo daily for one week; with 'suyod' combing twice daily. (2)For lice eggs (nits), apply hot vinegar for half an hour after shampooing; then 'suyod' (fine combing) thoroughly. (3)Bedtime, pound 1/2 cup of atis seeds and mix with 1/4 cup of oil. Apply mixture thoroughly to the scalp and hair. Wrap the hair and head overnight. Shampoo in the morning and follow with fine tooth combing. Do daily for 3-5 days. (4) Paste of the crushed seeds in water, applied to the scalp. The same used as abortifacient applied to the os uteri.",
            "Antiseptic, astringent & anthelminthic ,Kills bacteria, fungi and ameba, Used to treat diarrhea, nosebleeding, For Hypertension, diabetes and Asthma, Promotes menstruation",
            "rheumatism and leucorrhea, dysentery, Cough, Diarrhea, menorrhagia, leucorrhea, hemorrhoidal bleeding, and hemorrhage from the lungs, nasal catarrh, and for lumbrici, antisyphilitic, scabies and other parasitic skin diseases. Manga is a large tree, with a dense and spreading crown. Leaves are oblong to oblong-lanceolate, 10 to 30 centimeters long. The flowers are yellow, small, 3 to 4 millimeters long, borne on erect and hairy panicles, which as as often as long as the leaves. The fruit is a drupe, of varying shades of yellow, fleshy, oblong-ovoid,10 to 15 centimeters long, and slightly compressed, the skin is thin, and in the center is a large flattened, fibrous seed, and when ripe, surrounded by an edible yellow pulp. Bark and seeds are astringent. In Cambodia, used in hot lotions for rheumatism and leucorrhea;  Cough: Drink infusion of young leaves as needed; Diarrhea: Take decoction of bark or kernel as tea; Fluid extract, or infusion, used in menorrhagia, leucorrhea, hemorrhoidal bleeding, and hemorrhage from the lungs, nasal catarrh, and for lumbrici; Gum resin from the bark and fruit is used as sudorific; also as antisyphilitic; Gum resin from bark, mixed with coconut oil, used for scabies and other parasitic skin diseases; Juice of leaves used for dysentery." ,
            "Cold, Muscle pain, Acne, Dandruff, Toothache, Headaches, Allergies, Intestinal parasites, Menstrual cramps, Oregano is an erect, spreading, branched, rather coarse, strongly aromatic, green herb, with fleshy stems. Leaves are fleshy, broadly ovate, 4 to 9 centimeters long, often heart-shaped, and somewhat hairy, with rounded toothed margins, with the tip and base decurrent. Flowers are small, and occur in distant whorls. For burns: macerated fresh leaves applied externally to burns; For Bites, Headaches: Leaves are bruised and applied to centipede and scorpion bites. Also, applied to temples and forehead for headache, help in place by a bandage; For Asthma: Leaves in infusion or as syrup used as aromatic and carminative; used for dyspepsia and also as a cure for asthma; for dyspepsia, asthma, chronic coughs, bronchitis, colic, flatulence, rheumatism: juice of the leaves, The dose is one tablespoonful of the fresh juice every hour for adults and one teaspoonful every two hours, four times daily, for children. As an infusion, 50 to 60 grams to a pint of boiling water, and drink the tea, 4 to 5 glasses a day. For children, 1/2 cup 4 times daily; For Otalgia: pour the fresh, pure juice into the ear for 10 minutes; For carbuncles, boils, sprains, felons, painful swellings: Apply the poultice of leaves to the affected area, four times daily; For sore throats, a decoction of two tablespoonfuls of dried leaves to a pint of boiling water, taken one hour before or after meals.",
            "headaches, wounds, abscesses, arthritis, strengthens the gums, blennorhea, boils. Is a genus of monocots of about 600 known species, varying in size from small shrubs less than a meter to medium-sized trees of about 20 meters.In the Philippines there are 48 species of Pandanus, many of them are endemic, growing in various habitats, from sandy beaches, mangroves and primary forests. The fruit of some species are edible, eaten by bats, rats, crabs, elephants and lizards. The majority of species are dispersed primarily by water. For Headaches: Poultice of fresh leaves mixed with oil also used for headaches; For Poultice of fresh leaves mixed with oil also used for headaches; For Abscesses: Poultice of mash of cabbage of plant, mixed with salt and juice of Citrus microcarpa; For Arthritis: Decoction of roots believed to have aphrodisiac and cardiotonic properties; Chewing the roots strengthens the gums; For Blennorhea: Decoction of aerial roots use as beverage for cases of blennorrhea; For Boils: Leaves of plant triturated into a mash, slightly salted and added with juice of Citrus microcarpa, used as hot poultice " ,
            };

    //String leaf_other[] = {"SECRET"};
    String leaf_other = "SECRET";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_search_result);
        setResults();
        //setMockResults();
    }

    public void setMockResults(){

        //Get image from previous intent

        //Set image to background
        //ImageView img = (ImageView) findViewById(R.id.imgLeaf);
        //img.setImageResource(R.drawable.ps_pic1);

        //Set the value of the Leaf ID in the string arrays

        //Get UI Variables
        TabLayout tab = (TabLayout) findViewById(R.id.tbg);
        //When a Tab is selected
        final TextView text = (TextView) findViewById(R.id.txtDisplay);
        final int finalId = 7;
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("SELECTED TAB: ",tab.getText()+" = "+tab.getPosition());
                if(tab.getPosition() == 0){
                    text.setText(leaf_info[finalId]);
                } else if(tab.getPosition() == 1){
                    text.setText(leaf_use[finalId]);
                } else if(tab.getPosition() == 2){
                    text.setText(leaf_other);
                } else {
                    text.setText("SELECT");
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
        text.setText(leaf_info[finalId]);
    }

    public void setResults(){

        //Get image from previous intent
        Bundle extras   = getIntent().getExtras();
        int id          = extras.getInt("id");

        //Set image to background
        //ImageView img = (ImageView) findViewById(R.id.imgLeaf);
        //img.setImageResource(id);

        /*final ImageView leaf_pic_view = (ImageView) findViewById(R.id.imgLeaf);
        leaf_pic_view.setImageResource(id);

        final int finalId1 = id;
        leaf_pic_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set the Dialog Image
                ImageView dialog_img = (ImageView) findViewById(R.id.dialog_imageview);
                dialog_img.setImageResource(finalId1);

                //Show the dialog with the Leaf Image
                AlertDialog.Builder alertadd    = new AlertDialog.Builder(PictureSearchResult.this);
                LayoutInflater factory          = LayoutInflater.from(PictureSearchResult.this);
                final View view = factory.inflate(R.layout.view_image_dialog, null);
                alertadd.setView(view);
                alertadd.setNeutralButton("Here!", new DialogInterface.OnClickListener(){   public void onClick(DialogInterface dlg, int sumthin) {}});
                alertadd.show();
            }
        });*/

        //Set the value of the Leaf ID in the string arrays

        switch (id){
            //case R.drawable.ps_pic0:  id = 0; break;
            case R.drawable.ps_pic1:  id = 0; break;
            case R.drawable.ps_pic2:  id = 1; break;
            case R.drawable.ps_pic3:  id = 2; break;
            case R.drawable.ps_pic4:  id = 3; break;
            case R.drawable.ps_pic5:  id = 3; break;
            case R.drawable.ps_pic6:  id = 4; break;
            //case R.drawable.ps_pic7:  id = 6; break;
            //case R.drawable.ps_pic8:  id = 7; break;
            //case R.drawable.ps_pic5:  id = 5; break;
        }

        //Get UI Variables
        TabLayout tab = (TabLayout) findViewById(R.id.tbg);
        final TextView text = (TextView) findViewById(R.id.txtDisplay);

        //When a Tab is selected
        final int finalId = id;
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("SELECTED TAB: ",tab.getText()+" = "+tab.getPosition());
                if(tab.getPosition() == 0){
                    text.setText(leaf_info[finalId]);
                } else if(tab.getPosition() == 1){
                    text.setText(leaf_use[finalId]);
                } else if(tab.getPosition() == 2){
                    text.setText(leaf_other);
                } else {
                    text.setText("SELECT");
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
        text.setText(leaf_info[id]);
    }

}
