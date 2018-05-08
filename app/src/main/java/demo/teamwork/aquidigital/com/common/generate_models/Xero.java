package demo.teamwork.aquidigital.com.common.generate_models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Xero{

	@SerializedName("connected")
	public abstract String connected();

	@SerializedName("basecurrency")
	public abstract String basecurrency();

	@SerializedName("countrycode")
	public abstract String countrycode();

	@SerializedName("organisation")
	public abstract String organisation();

	@SerializedName("enabled")
	public abstract boolean isEnabled();

	public static TypeAdapter<Xero> typeAdapter(Gson gson) {
		return new AutoValue_Xero.GsonTypeAdapter(gson);
	}
}