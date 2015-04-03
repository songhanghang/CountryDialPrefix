# countryDispaly
获取所有国家的 name iso ，可以指定输出语言

  //获取所有国家的语言
        Locale[] all = Locale.getAvailableLocales();
        for (Locale locale : all) {
            Log.e("语言","国家名字：" + locale.getDisplayCountry() + "语言：" + locale.getLanguage());
        }
      

        //获取默认语言环境下的国家信息
        ArrayList<Country> countries = CountryManger.getCountryArrayList(this);
        for (Country country : countries) {
            Log.e("国家", country.toString());
        }

       
        //获取指定的国家语言信息
        ArrayList<Country> countriesByLanguage = CountryManger.getCountryArrayList(this, Locale.ENGLISH);
        for (Country country : countriesByLanguage) {
            Log.e("国家", country.toString());
        }
