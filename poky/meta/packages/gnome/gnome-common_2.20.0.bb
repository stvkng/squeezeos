LICENSE = "GPL"
SECTION = "x11/gnome"
PR = "r1"
DESCRIPTION = "Common macros for building GNOME applications"
inherit gnome

# all isn't appropriate since STAGING_DATADIR is target specific
# PACKAGE_ARCH="all"

# The omf.make file failed if scrollkeeper doesn't happen to be
# installed

SRC_URI += "file://omf.patch;patch=1"

EXTRA_AUTORECONF = ""
DEPENDS = ""

FILES_${PN} += "${datadir}/aclocal"
FILES_${PN}-dev = ""

do_stage () {
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	make DESTDIR="${STAGE_TEMP}" install
	cp -pPR ${STAGE_TEMP}${bindir}/* ${STAGING_BINDIR_NATIVE}
	install -d ${STAGING_DATADIR}/gnome-common
	install -d ${STAGING_DATADIR}/aclocal
	cp -pPR ${STAGE_TEMP}${datadir}/gnome-common/* ${STAGING_DATADIR}/gnome-common
	cp -pPR ${STAGE_TEMP}${datadir}/aclocal/* ${STAGING_DATADIR}/aclocal
	rm -rf ${STAGE_TEMP}
}
