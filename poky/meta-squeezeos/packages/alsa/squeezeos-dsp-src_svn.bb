DESCRIPTION = "SqueezeOS DSP - Private code"
LICENSE = "Confidential"

PV = "7.7.3"
PR = "r16676"

PROVIDES = "squeezeos-dsp"

DEPENDS += "alsa-lib"

# no thumb here thanks!
ARM_INSTRUCTION_SET = "arm"

SRC_URI="${NONFREE_ARTIFACTS_URI}/babydsp/babydsp-${PV}${PR}.tar.gz"

S = "${WORKDIR}/squeezeos_dsp"

do_install() {
	mkdir -p ${D}/${libdir}/alsa-lib
	install -m 0644 .libs/libasound_module_pcm_babydsp.so.0.0.0 ${D}/${libdir}/alsa-lib/libasound_module_pcm_babydsp.so
}

PACKAGES = "squeezeos-dsp squeezeos-dsp-dbg"

FILES_squeezeos-dsp = "${libdir}/alsa-lib"
FILES_squeezeos-dsp-dbg = "${libdir}/alsa-lib/.debug"
