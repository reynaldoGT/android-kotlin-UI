package com.dosan.baseballui.auth


import androidx.appcompat.app.AppCompatActivity

class Auth(var activity: AppCompatActivity) {


    private val ACCESS_TOKEN = "token"
    private val SETTINGS = "SETTINGS"
    private val DISPLAY_NAME = "DISPLAY_NAME"
    private val URL_IMAGE = "URL_IMAGE"
    private val EMAIL = "EMAIL"
    private val SHOW_INTRO = "SHOW_INTRO"
    private val LOGIN_TYPE = "TYPE_SESSION"


    fun getToken(): String {

        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val token = settings.getString(ACCESS_TOKEN, "")
        return token!!
    }

    fun hayToken(): Boolean {
        return getToken() != ""
    }


    fun clearShared() {
        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val editor = settings.edit()

        editor.putString(ACCESS_TOKEN, "")
        editor.putString(EMAIL, "")
        editor.putString(URL_IMAGE, "")
        editor.putString(DISPLAY_NAME, "")
        editor.putString(ACCESS_TOKEN, "")
        editor.putString(LOGIN_TYPE, "")

        editor.apply()
    }

    fun getEmailName(): String {

        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val displayName = settings.getString(DISPLAY_NAME, "")
        return displayName!!
    }

    fun saveDataInfo(userInfo: SaveUserInfo) {
        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val editor = settings.edit()

        editor.putString(DISPLAY_NAME, userInfo.displayName)
        editor.putString(EMAIL, userInfo.email)
        editor.putString(URL_IMAGE, userInfo.urlImage)
        editor.putString(ACCESS_TOKEN, userInfo.idToken)
        editor.putString(ACCESS_TOKEN, userInfo.idToken)
        editor.putString(LOGIN_TYPE, userInfo.type_session)


        editor.apply()
    }

    fun getUserInfo(): SaveUserInfo {
        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val email = settings.getString(EMAIL, "")
        val displayName = settings.getString(DISPLAY_NAME, "")
        val uriImage = settings.getString(URL_IMAGE, "")
        val token = settings.getString(ACCESS_TOKEN, "")
        val typeSession = settings.getString(LOGIN_TYPE, "")


        return SaveUserInfo(
            email!!,
            displayName!!,
            uriImage!!,
            token!!,
            typeSession!!
        )
    }

    fun jumpedIntro(jump: String) {
        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val editor = settings.edit()

        editor.putString(SHOW_INTRO, jump)
//        editor.putString(IMAGE_URL, imageUrl)
        editor.apply()
    }

    fun getJumpStatus(): String {
        val settings = activity.getSharedPreferences(SETTINGS, 0)
        val token = settings.getString(SHOW_INTRO, "")
        return token!!
    }
//
//    fun backLogin() {
//        val homeIntent = Intent(activity, LoginActivity::class.java)
//        startActivity(homeIntent)
//    }

//        fun nextActivity(actualContext: Context) {
//            val homeIntent = Intent(actualContext, InicioActivity::class.java).f
//            apply
//            startActivity(homeIntent)
//        }


}