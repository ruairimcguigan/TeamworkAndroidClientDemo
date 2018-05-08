package demo.teamwork.aquidigital.com.common.generate_models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class MicrosoftConnectors{

	@SerializedName("enabled")
	public abstract boolean isEnabled();

	public static TypeAdapter<MicrosoftConnectors> typeAdapter(Gson gson) {
		return new AutoValue_MicrosoftConnectors.GsonTypeAdapter(gson);
	}
}