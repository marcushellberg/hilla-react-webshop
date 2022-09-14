import routes from 'Frontend/app/routes.js';
import React, { useState } from 'react';
import { Link, Outlet } from 'react-router-dom';
import { AppLayout, DrawerToggle, Tab, Tabs } from 'react-vaadin-components';
import './App.css';

function App() {
  const [selected, setSelected] = useState(0);

  return (
    <AppLayout>
      <header slot="navbar" className="flex gap-m items-center">
        <DrawerToggle />
        <h1 className="m-0 text-l">Hilla Cool Webshop</h1>
      </header>

      <nav slot="drawer">
        <Tabs
          orientation="vertical"
          selected={selected}
          onSelectedChanged={(e) => {
            dispatchEvent(new CustomEvent('close-overlay-drawer'));
            setSelected(e.detail.value);
          }}
        >
          {routes
            .filter((route) => route.displayInMenu)
            .map(({ path, icon, name }) => (
              <Tab className="menu-item" key={path}>
                {icon}
                {path && <Link to={`/${path}`}>{name}</Link>}
              </Tab>
            ))}
        </Tabs>
      </nav>

      <Outlet />
    </AppLayout>
  );
}

export default App;
