package com.yaooort.seu.magicfilter.utils;

import com.yaooort.seu.magicfilter.advanced.MagicAmaroFilter;
import com.yaooort.seu.magicfilter.advanced.MagicAntiqueFilter;
import com.yaooort.seu.magicfilter.advanced.MagicBeautyFilter;
import com.yaooort.seu.magicfilter.advanced.MagicBlackCatFilter;
import com.yaooort.seu.magicfilter.advanced.MagicBrannanFilter;
import com.yaooort.seu.magicfilter.advanced.MagicBrooklynFilter;
import com.yaooort.seu.magicfilter.advanced.MagicCalmFilter;
import com.yaooort.seu.magicfilter.advanced.MagicCoolFilter;
import com.yaooort.seu.magicfilter.advanced.MagicCrayonFilter;
import com.yaooort.seu.magicfilter.advanced.MagicEarlyBirdFilter;
import com.yaooort.seu.magicfilter.advanced.MagicEmeraldFilter;
import com.yaooort.seu.magicfilter.advanced.MagicEvergreenFilter;
import com.yaooort.seu.magicfilter.advanced.MagicFreudFilter;
import com.yaooort.seu.magicfilter.advanced.MagicHealthyFilter;
import com.yaooort.seu.magicfilter.advanced.MagicHefeFilter;
import com.yaooort.seu.magicfilter.advanced.MagicHudsonFilter;
import com.yaooort.seu.magicfilter.advanced.MagicImageAdjustFilter;
import com.yaooort.seu.magicfilter.advanced.MagicInkwellFilter;
import com.yaooort.seu.magicfilter.advanced.MagicKevinFilter;
import com.yaooort.seu.magicfilter.advanced.MagicLatteFilter;
import com.yaooort.seu.magicfilter.advanced.MagicLomoFilter;
import com.yaooort.seu.magicfilter.advanced.MagicN1977Filter;
import com.yaooort.seu.magicfilter.advanced.MagicNashvilleFilter;
import com.yaooort.seu.magicfilter.advanced.MagicNostalgiaFilter;
import com.yaooort.seu.magicfilter.advanced.MagicPixarFilter;
import com.yaooort.seu.magicfilter.advanced.MagicRiseFilter;
import com.yaooort.seu.magicfilter.advanced.MagicRomanceFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSakuraFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSierraFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSketchFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSkinWhitenFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSunriseFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSunsetFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSutroFilter;
import com.yaooort.seu.magicfilter.advanced.MagicSweetsFilter;
import com.yaooort.seu.magicfilter.advanced.MagicTenderFilter;
import com.yaooort.seu.magicfilter.advanced.MagicToasterFilter;
import com.yaooort.seu.magicfilter.advanced.MagicValenciaFilter;
import com.yaooort.seu.magicfilter.advanced.MagicWaldenFilter;
import com.yaooort.seu.magicfilter.advanced.MagicWarmFilter;
import com.yaooort.seu.magicfilter.advanced.MagicWhiteCatFilter;
import com.yaooort.seu.magicfilter.advanced.MagicXproIIFilter;
import com.yaooort.seu.magicfilter.base.MagicLookupFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageBrightnessFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageContrastFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageExposureFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageHueFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageSaturationFilter;
import com.yaooort.seu.magicfilter.base.gpuimage.GPUImageSharpenFilter;

public class MagicFilterFactory {

    public static GPUImageFilter initFilters(MagicFilterType type) {
        switch (type) {
            case NONE:
                return new GPUImageFilter();
            case WHITECAT:
                return new MagicWhiteCatFilter();
            case BLACKCAT:
                return new MagicBlackCatFilter();
            case SKINWHITEN:
                return new MagicSkinWhitenFilter();
            case BEAUTY:
                return new MagicBeautyFilter();
            case ROMANCE:
                return new MagicRomanceFilter();
            case SAKURA:
                return new MagicSakuraFilter();
            case AMARO:
                return new MagicAmaroFilter();
            case WALDEN:
                return new MagicWaldenFilter();
            case ANTIQUE:
                return new MagicAntiqueFilter();
            case CALM:
                return new MagicCalmFilter();
            case BRANNAN:
                return new MagicBrannanFilter();
            case BROOKLYN:
                return new MagicBrooklynFilter();
            case EARLYBIRD:
                return new MagicEarlyBirdFilter();
            case FREUD:
                return new MagicFreudFilter();
            case HEFE:
                return new MagicHefeFilter();
            case HUDSON:
                return new MagicHudsonFilter();
            case INKWELL:
                return new MagicInkwellFilter();
            case KEVIN:
                return new MagicKevinFilter();
            case LOCKUP:
                return new MagicLookupFilter("");
            case LOMO:
                return new MagicLomoFilter();
            case N1977:
                return new MagicN1977Filter();
            case NASHVILLE:
                return new MagicNashvilleFilter();
            case PIXAR:
                return new MagicPixarFilter();
            case RISE:
                return new MagicRiseFilter();
            case SIERRA:
                return new MagicSierraFilter();
            case SUTRO:
                return new MagicSutroFilter();
            case TOASTER2:
                return new MagicToasterFilter();
            case VALENCIA:
                return new MagicValenciaFilter();
            case XPROII:
                return new MagicXproIIFilter();
            case EVERGREEN:
                return new MagicEvergreenFilter();
            case HEALTHY:
                return new MagicHealthyFilter();
            case COOL:
                return new MagicCoolFilter();
            case EMERALD:
                return new MagicEmeraldFilter();
            case LATTE:
                return new MagicLatteFilter();
            case WARM:
                return new MagicWarmFilter();
            case TENDER:
                return new MagicTenderFilter();
            case SWEETS:
                return new MagicSweetsFilter();
            case NOSTALGIA:
                return new MagicNostalgiaFilter();
            case SUNRISE:
                return new MagicSunriseFilter();
            case SUNSET:
                return new MagicSunsetFilter();
            case CRAYON:
                return new MagicCrayonFilter();
            case SKETCH:
                return new MagicSketchFilter();
            //image adjust
            case BRIGHTNESS:
                return new GPUImageBrightnessFilter();
            case CONTRAST:
                return new GPUImageContrastFilter();
            case EXPOSURE:
                return new GPUImageExposureFilter();
            case HUE:
                return new GPUImageHueFilter();
            case SATURATION:
                return new GPUImageSaturationFilter();
            case SHARPEN:
                return new GPUImageSharpenFilter();
            case IMAGE_ADJUST:
                return new MagicImageAdjustFilter();
            default:
                return null;
        }
    }
}
