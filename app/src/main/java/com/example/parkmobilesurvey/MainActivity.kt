package com.example.parkmobilesurvey

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.parkmobilesurvey.ui.main.MainFragment
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
//
////        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
//        // Pranav was here
//        // Keya was here
//        // Pranav was here again
//        // stephane was here
//    }
//}


//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationRequest
//import com.google.android.gms.location.LocationServices

import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.parkmobilesurvey.databinding.MainActivityBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: MainActivityBinding
    private lateinit var namePark: String
    private lateinit var next: Button
    private final val EXTRA: String = "park"

    private var latitude:Double= 0.toDouble()
    private var longitude: Double = 0.toDouble()

    private lateinit var mLastLocation: Location
    private var mMarker: Marker?=null

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: com.google.android.gms.location.LocationRequest
    private lateinit var locationCallback: LocationCallback

    companion object{
        private const val MY_PERMISSION_CODE:Int = 1000

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fuse = LocationServices.getFusedLocationProviderClient(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        val user = arrayOf("Fairland Recreational Park", "Fairland Regional Park",
            "Edgewood Neighborhood Park","Wheaton Regional Park", "Park At Fairland",
            "Maryland-National Capital Park","Martin Luther King Jr. Recreational Park",
            "Rock Creek Regional Park","Valley Mill Special Park","Cross Creek Club Local Park",
            "McKnew Local Park","Roland B. Sweitzer Community Park","Burtonsville Local Park",
            "Beltsville Neighborhood Park","Stonehedge Local Park","Kemp Mill Urban Park",
            "Wheaton Regional Park Adventure Playground","Maryland-National Capital Park Silver Spring",
            "Pilgrim Hills Local Park","Patapsco Valley State Park - Hollofield Area","Greenbelt Park",
            "Watkins Regional Park","Scotts Cove Recreation Area","Tire Park","Centennial Park",
            "Woodlawn Manor Cultural Park","Cabin John Regional Park","Glen Echo Park","Lake Artemesia Natural Area",
            "Acredale Community Park")

        val userAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, user)
        binding.list.adapter = userAdapter

        binding.list.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val intent = Intent(this@MainActivity, pageOneSurvey::class.java)
                val search = p0!!.getItemAtPosition(p2)
                val query = search.toString()
                intent.putExtra(EXTRA, query)
                startActivity(intent)
            }
        })

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.search.clearFocus()
                if(user.contains(p0)){
                    userAdapter.filter.filter(p0)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                userAdapter.filter.filter(p0)
                return false
            }
        })

//        Toast.makeText(this,name,Toast.LENGTH_SHORT)

//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
//            checkLocationPermission()
//
//        buildLocationRequest()
//        buildLocationCallBack()
//
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
//        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback,
//            Looper.myLooper()!!)
    }

//    public fun ParkName(): String {
//        return namePark
//    }

//    private fun buildLocationCallBack() {
//        locationCallback = object: LocationCallback(){
//            override fun onLocationResult(p0: LocationResult) {
//                mLastLocation = p0!!.locations[p0!!.locations.size-1]
//
//                if(mMarker != null){
//                    mMarker!!.remove()
//                }
//                latitude = mLastLocation.latitude
//                longitude = mLastLocation.longitude
//
//                val latLng = LatLng(latitude, longitude)
//                val markerOptions = MarkerOptions().position(latLng).title("Your position")
//                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
//
//                mMarker = mMap!!.addMarker(markerOptions)
//
//                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
//                mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11f))
//            }
//        }
//
//    }
//
//    private fun buildLocationRequest() {
//        locationRequest = com.google.android.gms.location.LocationRequest()
//        locationRequest.priority = com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
//        locationRequest.interval = 5000
//        locationRequest.fastestInterval = 3000
//        locationRequest.smallestDisplacement = 10f
//
//    }
//
//    private fun checkLocationPermission(): Boolean {
//        return if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=
//            PackageManager.PERMISSION_GRANTED){
//            if(ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION)){
//                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSION_CODE)
//            }else{
//                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSION_CODE)
//
//            }
//            false
//        } else
//            true
//    }
//
//    @SuppressLint("MissingSuperCall")
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray, ) {
//        when(requestCode){
//            MY_PERMISSION_CODE->{
//                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
//                        if(checkLocationPermission()){
//                            mMap!!.isMyLocationEnabled = true
//                        }
//                }
//                else{
//                    Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val fairland = LatLng(39.0825, -76.9298)
        mMap.addMarker(MarkerOptions().position(fairland).title("Fairland Recreational Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fairland))

        val fairland2 = LatLng(39.080909, -76.921150)
        mMap.addMarker(MarkerOptions().position(fairland2).title("Fairland Regional Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fairland2))

        val edgewood = LatLng(39.0845, -76.9372)
        mMap.addMarker(MarkerOptions().position(edgewood).title("Edgewood Neighborhood Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(edgewood))

        val wheaton = LatLng(39.0519, -77.0431)
        mMap.addMarker(MarkerOptions().position(wheaton).title("Wheaton Regional Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wheaton))

        val ParkAt = LatLng(39.0799, -76.9217)
        mMap.addMarker(MarkerOptions().position(ParkAt).title("Park At Fairland").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ParkAt))

        val capital = LatLng(39.0802, -76.9203)
        mMap.addMarker(MarkerOptions().position(capital).title("Maryland-National Capital Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(capital))

        val martin = LatLng(39.0558, -76.9858)
        mMap.addMarker(MarkerOptions().position(martin).title("Martin Luther King Jr. Recreational Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(martin))

        val rock = LatLng(39.1221, -77.1345)
        mMap.addMarker(MarkerOptions().position(rock).title("Rock Creek Regional Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rock))

        val valley = LatLng(39.0654, -76.9781)
        mMap.addMarker(MarkerOptions().position(valley).title("Valley Mill Special Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(valley))

        val cross = LatLng(39.0711, -76.9373)
        mMap.addMarker(MarkerOptions().position(cross).title("Cross Creek Club Local Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cross))

        val Mcknew = LatLng(39.1003, -76.9175)
        mMap.addMarker(MarkerOptions().position(Mcknew).title("McKnew Local Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mcknew))

        val Roland = LatLng(39.10444474, -76.87532625)
        mMap.addMarker(MarkerOptions().position(Roland).title("Roland B. Sweitzer Community Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Roland))

        val Burtons = LatLng(39.1166, -76.9546)
        mMap.addMarker(MarkerOptions().position(Burtons).title("Burtonsville Local Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Burtons))

        val Belts = LatLng(39.0510, -76.9262)
        mMap.addMarker(MarkerOptions().position(Belts).title("Beltsville Neighborhood Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Belts))

        val stonehedge = LatLng(39.0541, -76.9720)
        mMap.addMarker(MarkerOptions().position(stonehedge).title("Stonehedge Local Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stonehedge))

        val kemp = LatLng(39.0414, -77.0298)
        mMap.addMarker(MarkerOptions().position(kemp).title("Kemp Mill Urban Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kemp))

        val wheaton2 = LatLng(39.0544, -77.0428)
        mMap.addMarker(MarkerOptions().position(wheaton2).title("Wheaton Regional Park Adventure Playground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wheaton2))

        val capital2 = LatLng(39.0565, -76.9848)
        mMap.addMarker(MarkerOptions().position(capital2).title("Maryland-National Capital Park Silver Spring").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(capital2))

        val Pilgrim  = LatLng(39.0646, -76.9790)
        mMap.addMarker(MarkerOptions().position(Pilgrim ).title("Pilgrim Hills Local Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Pilgrim))

        val patapsco  = LatLng(39.2947, -76.7854)
        mMap.addMarker(MarkerOptions().position(patapsco).title("Patapsco Valley State Park - Hollofield Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(patapsco))

        val creen  = LatLng(38.9950, -76.8946)
        mMap.addMarker(MarkerOptions().position(creen).title("Greenbelt Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(creen))

        val watkins  = LatLng(38.889, -76.7886)
        mMap.addMarker(MarkerOptions().position(watkins).title("Watkins Regional Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(watkins))
        // new park
        val scott  = LatLng(39.1372, -76.8911)
        mMap.addMarker(MarkerOptions().position(scott).title("Scotts Cove Recreation Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(scott))

        val tire  = LatLng(39.2454, -76.7452)
        mMap.addMarker(MarkerOptions().position(tire).title("Tire Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tire))

        val cent  = LatLng(36.1489, -86.8127)
        mMap.addMarker(MarkerOptions().position(cent).title("Centennial Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cent))

        val wood  = LatLng(39.1282, -77.0266)
        mMap.addMarker(MarkerOptions().position(wood).title("Woodlawn Manor Cultural Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wood))

        val cabin  = LatLng(39.0350, -77.1506)
        mMap.addMarker(MarkerOptions().position(cabin).title("Cabin John Regional Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cabin))

        val glen  = LatLng(38.9660, -77.1387)
        mMap.addMarker(MarkerOptions().position(glen).title("Glen Echo Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(glen))

        val lake  = LatLng(38.9909, -76.9220)
        mMap.addMarker(MarkerOptions().position(lake).title("Lake Artemesia Natural Area").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lake))

        val acre  = LatLng(38.9994, -76.9341)
        mMap.addMarker(MarkerOptions().position(acre).title("Acredale Community Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(acre))






//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
//            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//                mMap!!.isMyLocationEnabled = true
//            }
//        }
//        else{
//            mMap!!.isMyLocationEnabled = true
//
//        }

        mMap.uiSettings.isZoomControlsEnabled=true

        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(LatLng(39.00,-77.00) , 10.0f) )
    }
}

