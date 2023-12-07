package ru.nikitin.config;

public enum ImageType {
    CURRENT_SCREEN("D:\\Java\\SWGOH_bot\\src\\main\\resources\\screenshot\\screenshot.png"),
    MAIN_SCREEN("D:\\Java\\SWGOH_bot\\src\\main\\resources\\main_screen.png"),
    MAIN_SCREEN_BLUR("D:\\Java\\SWGOH_bot\\src\\main\\resources\\main_screen_gray_blur.png"),
    BLUESTACKS_SCREEN("D:\\Java\\SWGOH_bot\\src\\main\\resources\\bluestacks_screen.png"),
    LOAD_SCREEN("D:\\Java\\SWGOH_bot\\src\\main\\resources\\load_screen.png"),
    SWGOH_ICON("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\swgoh_icon.png"),
    LOAD_ICON("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\load_icon.png"),
    ARENA_ICON("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\icon_arena.png"),
    CHARACTER_ARENA("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\character_arena_button.png"),
    FLEET_ARENA("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_arena_button.png"),
    GUILD_ACTIVITY_ICON("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\icon_guild_activity.png"),
    OBJECTIVES("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\objectives.png"),
    HOME("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\home_button.png"),
    GET("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\get_button.png"),
    OBJECTIVES_BLUR("D:\\Java\\SWGOH_bot\\src\\main\\resources\\objectives_gray_blur.png"),
    ARENA_BANNERS("D:\\Java\\SWGOH_bot\\src\\main\\resources\\arena_banners.png"),
    ARENA_MARK1("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\arena_mark1.png"),
    ARENA_MARK2("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\arena_mark2.png"),
    AGAINST("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\against_icon.png"),
    SHOP_CLOSE("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\shop_close_icon.png"),
    SHOP_CLOSE_ALT("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\shop_close_icon_alt.png"),
    CHOOSE_BATTLE("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\choose_battle.png"),
    BATTLE("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\battle.png"),
    SETTINGS("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\settings.png"),
    GIVE_UP("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\give_up.png"),
    CHALLENGES("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\challenges.png"),
    CHALLENGES_ICON("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\challenges_icon.png"),
    CHAR_CURRENCY("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\char_currency_icon.png"),
    CHOOSE("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\choose_icon.png"),
    COUPONS("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\coupons.png"),
    COUPONS_GW("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\coupons_gw.png"),
    DAILY_SCREEN_MARK1("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\daily_screen_mark1.png"),
    DAILY_SCREEN_MARK2("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\daily_screen_mark2.png"),
    SPEND_COUPONS("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\spend_coupons.png"),
    YES("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\yes_button.png"),
    NEXT("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\next_button.png"),
    BACK("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\back_button.png"),
    SHIPS("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\ships.png"),
    SHIPS_ICON("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\ship_icon.png"),
    FLEET_CHALLENGES("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_challenges.png"),
    FLEET_BATTLES("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_battles.png"),
    FLEET_ARENA_ALT("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_arena.png"),
    FLEET_CURRENCY("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_currency_icon.png"),
    GALACTIC_BATTLES("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\galactic_battles.png"),
    GALACTIC_BATTLES_MARK("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\galactic_battles_mark.png"),
    PARTICIPATE_GW("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\participate_GW.png"),
    POSITIONS("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\positions_icon.png"),
    RELOAD("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\reload.png"),
    REFRESH("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\refresh_icon.png"),
    SQUAD_POWER("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\squad_power.png"),
    FLEET_SQUAD_POWER("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_squad_power.png"),
    FLEET_SQUAD_MARK("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\fleet_squad_mark.png"),
    EFFECTS_DISPLAY("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\effects_displaying.png"),
    ARENA_TABLE("D:\\Java\\SWGOH_bot\\src\\main\\resources\\icons\\arena_table.png");

    private final String path;

    ImageType(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}