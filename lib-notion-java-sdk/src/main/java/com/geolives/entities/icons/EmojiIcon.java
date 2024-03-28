package com.geolives.entities.icons;

import com.geolives.entities.enums.IconType;

public class EmojiIcon extends Icon {
    private String emoji;

    public EmojiIcon() {
        super(IconType.EMOJI);
    }

    public String getEmoji() {
        return this.emoji;
    }

    public void setEmoji(final String emoji) {
        this.emoji = emoji;
    }
}
