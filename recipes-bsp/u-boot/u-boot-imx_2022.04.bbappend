FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

UBOOT_SRC = "git://github.com/SoMLabs/somlabs-uboot-imx.git;protocol=https"
SRCBRANCH = "somlabs-imx_v2022.04_5.15.52-2.1.0"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH} \
           file://splash.bmp \
           "

SRCREV = "4479b45eb9f6a03002389b18bb44673c4be9c67f"

do_install:append:visioncb-6ull-std() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 ${WORKDIR}/splash.bmp ${DEPLOY_DIR_IMAGE}/splash.bmp
}

do_install:append:starsom-cb-6ull() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 ${WORKDIR}/splash.bmp ${DEPLOY_DIR_IMAGE}/splash.bmp
}
