// @ts-check
// Note: type annotations allow type checking and IDEs autocompletion

const lightCodeTheme = require("prism-react-renderer/themes/duotoneLight");
const darkCodeTheme = require("prism-react-renderer/themes/duotoneDark");

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: "Component Box",
  tagline:
    "A Kotlin multiplatform library for building dynamic server-driven UI",
  url: "https://dropbox.github.io",
  baseUrl: "/componentbox/",
  onBrokenLinks: "throw",
  onBrokenMarkdownLinks: "warn",
  favicon: "img/favicon.ico",
  organizationName: "dropbox",
  projectName: "componentbox",
  trailingSlash: false,
  deploymentBranch: "site",

  themes: ["@docusaurus/theme-live-codeblock"],

  presets: [
    [
      "classic",
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: require.resolve("./sidebars.js"),
        },
        theme: {
          customCss: require.resolve("./src/css/custom.css"),
        },
      }),
    ],
  ],

  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      navbar: {
        title: "Component Box",
        logo: {
          alt: "Component Box",
          src: "img/logo.png",
        },
        items: [
          {
            type: "doc",
            docId: "index",
            position: "left",
            label: "Docs",
          },

          {
            type: "doc",
            docId: "component-box",
            position: "left",
            label: "API",
          },

          {
            type: "docsVersionDropdown",
            position: "right",
          },

          {
            href: "https://github.com/dropbox/componentbox",
            label: "GitHub",
            position: "right",
          },
        ],
      },
      footer: {
        logo: {
          alt: "Dropbox Open Source Logo",
          src: "img/open_source.svg",
          href: "https://opensource.dropbox.com",
          width: 160,
          height: 51,
        },

        links: [
          {
            title: "Community",
            items: [
              {
                label: "Stack Overflow",
                href: "https://stackoverflow.com/questions/tagged/componentbox",
              },
              {
                label: "Twitter",
                href: "https://twitter.com/dropbox",
              },
            ],
          },

          {
            title: "Powered By",

            items: [
              {
                label: "Jetpack Compose",
                href: "https://developer.android.com/jetpack/compose",
              },
              {
                label: "Zipline",
                href: "https://github.com/cashapp/zipline",
              },

              {
                label: "Mavericks",
                href: "https://github.com/airbnb/mavericks",
              },
            ],
          },

          {
            title: "More",

            items: [
              {
                label: "About Us",
                href: "https://www.dropbox.com/about",
              },
              {
                label: "Jobs",
                href: "https://www.dropbox.com/jobs",
              },
            ],
          },
        ],
        copyright: `Copyright © ${new Date().getFullYear()} Dropbox, Inc.`,
      },
      prism: {
        theme: lightCodeTheme,
        darkTheme: darkCodeTheme,
      },
      colorMode: {
        disableSwitch: true,
      },
    }),
};

module.exports = config;
