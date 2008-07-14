SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes xdamage libxrender startup-notification expat"
PR="r4"


SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/1.1/matchbox-window-manager-${PV}.tar.gz \
	   file://kbdconfig \
           file://gconf-2.m4"

S = "${WORKDIR}/matchbox-window-manager-${PV}"

inherit autotools pkgconfig update-alternatives

FILES_${PN} = "${bindir}/* \
	       ${datadir}/matchbox \
	       ${sysconfdir}/matchbox \
	       ${datadir}/themes/blondie/matchbox \
	       ${datadir}/themes/Default/matchbox \
	       ${datadir}/themes/MBOpus/matchbox"

ALTERNATIVE_NAME = "x-session-manager"
ALTERNATIVE_LINK = "${bindir}/x-session-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-session"
ALTERNATIVE_PRIORITY = "10"

EXTRA_OECONF = " --enable-startup-notification --disable-xrm"

do_configure_prepend () {
        cp ${WORKDIR}/gconf-2.m4 ${S}/
}

do_install_prepend() {
	install ${WORKDIR}/kbdconfig ${S}/data/kbdconfig
}

