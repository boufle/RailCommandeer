package fr.railcommandeer.app.Navigation;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.*;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import com.squareup.picasso.Picasso;
import fr.railcommandeer.app.MainActivity;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.Utils.Gravatar;

/**
 * fr.railcommandeer.app.Navigation
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class NavigationDrawer {
    private   Drawer result;
    private   AccountHeader headerResult;
    private  CrossfadeDrawerLayout crossfadeDrawerLayout;

    public Drawer getResult() {
        return result;
    }

    public AccountHeader getHeaderResult() {
        return headerResult;
    }

    public NavigationDrawer(final MainActivity mainActivity, Toolbar toolbar, Bundle savedInstanceState) {
        //initialize and create the image loader logic
        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Picasso.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Picasso.with(imageView.getContext()).cancelRequest(imageView);
            }

        });
        // Create a few sample profile
          // NOTE you have to define the loader logic too. See the CustomApplication for more details
          IProfile profile = new ProfileDrawerItem().withName("Benjamin Penot").withEmail("bouflelol@gmail.com").withIcon(Gravatar.gravatarUrl("theobeaudenon@yahoo.fr"));

        // Create the AccountHeader
          headerResult = new AccountHeaderBuilder()
                .withActivity(mainActivity)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        profile
                ).withSelectionListEnabledForSingleProfile(false)

                  .withSavedInstance(savedInstanceState)
                .build();

        //Create the drawer
            result = new DrawerBuilder()
                .withActivity(mainActivity)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withDrawerLayout(R.layout.crossfade_drawer)
                .withDrawerWidthDp(72)
                .withGenerateMiniDrawer(true)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Accueil").withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Recherche").withIcon(GoogleMaterial.Icon.gmd_directions_transit).withIdentifier(2),
                        new PrimaryDrawerItem().withName("Mon Compte").withIcon(GoogleMaterial.Icon.gmd_account_circle).withIdentifier(3).withSelectable(false),
                         new PrimaryDrawerItem().withDescription("Consulter vos reservations").withName("Mes commandes").withIcon(GoogleMaterial.Icon.gmd_card_travel).withIdentifier(4),
                        new SectionDrawerItem().withName("Autre"),
                        new SecondaryDrawerItem().withName("A propos").withIcon(GoogleMaterial.Icon.gmd_help_outline).withIdentifier(5)
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {

                            if(((Nameable) drawerItem).getName().getText(mainActivity).equals("Mon Compte")){
                                mainActivity.GetClicked(10);
                            }else  if(((Nameable) drawerItem).getName().getText(mainActivity).equals("Recherche")){
                                mainActivity.GetClicked(0);
                            }else  if(((Nameable) drawerItem).getName().getText(mainActivity).equals("Consulter vos reservations")){
                                mainActivity.GetClicked(1);
                            }else  if(((Nameable) drawerItem).getName().getText(mainActivity).equals("Accueil")){
                                mainActivity.GetClicked(-1);
                            }else  if(((Nameable) drawerItem).getName().getText(mainActivity).equals("A propos")){
                                mainActivity.GetClicked(0);
                            }else {

                            }
                            //Toast.makeText(mainActivity, , Toast.LENGTH_SHORT).show();
                        }
                        //we do not consume the event and want the Drawer to continue with the event chain
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();


        //get the CrossfadeDrawerLayout which will be used as alternative DrawerLayout for the Drawer
        //the CrossfadeDrawerLayout library can be found here: https://github.com/mikepenz/CrossfadeDrawerLayout
        crossfadeDrawerLayout = (CrossfadeDrawerLayout) result.getDrawerLayout();

        //define maxDrawerWidth
        crossfadeDrawerLayout.setMaxWidthPx(DrawerUIUtils.getOptimalDrawerWidth(mainActivity));
        //add second view (which is the miniDrawer)
        final MiniDrawer miniResult = result.getMiniDrawer();
        //build the view for the MiniDrawer
        View view = miniResult.build(mainActivity);
        //set the background of the MiniDrawer as this would be transparent
        view.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(mainActivity, com.mikepenz.materialdrawer.R.attr.material_drawer_background, com.mikepenz.materialdrawer.R.color.material_drawer_background));
        //we do not have the MiniDrawer view during CrossfadeDrawerLayout creation so we will add it here
        crossfadeDrawerLayout.getSmallView().addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //define the crossfader to be used with the miniDrawer. This is required to be able to automatically toggle open / close
        miniResult.withCrossFader(new ICrossfader() {
            @Override
            public void crossfade() {
                boolean isFaded = isCrossfaded();
                crossfadeDrawerLayout.crossfade(400);

                //only close the drawer if we were already faded and want to close it now
                if (isFaded) {
                    result.getDrawerLayout().closeDrawer(GravityCompat.START);
                }
            }

            @Override
            public boolean isCrossfaded() {
                return crossfadeDrawerLayout.isCrossfaded();
            }
        });

    }
}
