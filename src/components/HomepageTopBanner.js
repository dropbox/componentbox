import React from "react";
import github from "../../static/img/github.png";
import twitter from "../../static/img/twitter.png";
import "../css/custom.css";

export default function HomepageTopBanner() {
  return (
    <div className="homepage_top_banner_cta">
      <p style={{ padding: 0, margin: 0 }}>
        If you like Component Box, give it a star on{" "}
        <span>
          <img
            src={github}
            alt="GitHub Logo"
            style={{ width: 30, paddingLeft: 4, paddingRight: 4 }}
          />
        </span>
        <a href="https://github.com/dropbox/componentbox" target="_blank">
          GitHub
        </a>{" "}
        and follow us on
        <span>
          <img
            src={twitter}
            alt="GitHub Logo"
            style={{ width: 30, paddingLeft: 4, paddingRight: 4 }}
          />
        </span>
        <a href="https://twitter.com/dropbox" target="_blank">
          Twitter
        </a>
      </p>
    </div>
  );
}
