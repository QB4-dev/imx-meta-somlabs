DESCRIPTION = "This is the basic image for SoMLabs boards and modules"

inherit core-image

IMAGE_FEATURES:append = " \
    debug-tweaks \
    tools-sdk \
    tools-debug \
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

IMAGE_INSTALL:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'somlabs-demo', '', d)} \
    firmwared \
    packagegroup-core-full-cmdline \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
"

IMAGE_INSTALL:append:visioncb-6ull-std-nand = " \
    kernel \
    kernel-devicetree \
"

IMAGE_INSTALL:remove:visioncb-6ull-std-nand = " \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
"